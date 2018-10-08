#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <time.h>
#include <unistd.h>

#define TOTAL_PORCOES   2           // capacidade do tacho
#define NUMERO_CONVIDADOS          10           // numero de convidados
#define NUMERO_PORCOES_CONSUMIDAS      1           // qtd de porcoes que cada convidado pega por vez
#define NUMERO_PORCOES_PRODUZIDAS      2           // qtd de porcoes que o cozinheiro produz por vez

typedef struct
{
    int tacho;   // tacho
    sem_t CHEIO;           /* keep track of the number of CHEIO spots */
    sem_t VAZIO;          /* keep track of the number of VAZIO spots */
    pthread_mutex_t fila;          /* enforce mutual exclusion to cozinha data */
} dados;

dados cozinha;


void *cozinheiro(void *id)
{
    int idCozinheiro = *(int*)id;

	while(true){
		
		while(cozinha.tacho > 0){
			// Avisa que ainda tem comida
			sem_post(&cozinha.CHEIO);
			// Espera esvaziar
	    	sem_wait(&cozinha.VAZIO);
		}
	        
	    // Bloqueia a fila da comida
	    pthread_mutex_lock(&cozinha.fila);
	    
	    // Produz a comida
	    cozinha.tacho = NUMERO_PORCOES_PRODUZIDAS;
	        
	    printf("[COZINHEIRO-%d] Fez %d porcoes...\n", idCozinheiro, NUMERO_PORCOES_PRODUZIDAS);
	    
	    printf("O tacho agora tem %d porcoes\n", cozinha.tacho);
	    
	    fflush(stdout);
	        
	    // libera a fila da comida
	    pthread_mutex_unlock(&cozinha.fila);
	        
	    // Avisa os convidados que tem comida
	    for(int i = 0; i < NUMERO_CONVIDADOS; i++){
	    	sem_post(&cozinha.CHEIO);
		}
	
	    // Aguarda um segundo
	    sleep(1);
	}
    
    return NULL;
}

void *convidado(void *id)
{
    int idConvidado = *(int*)id;
    
    while(true){
    	
    	while(cozinha.tacho < 1){
    		sem_post(&cozinha.VAZIO);
    		// Aguarda a commida chegar
    		sem_wait(&cozinha.CHEIO);
		}
    	
    	// Bloqueia a fila da comida
        pthread_mutex_lock(&cozinha.fila);
        
        if (cozinha.tacho < 1) {
        	pthread_mutex_unlock(&cozinha.fila);
        	continue;
		}
        
        // Pega uma porção
        cozinha.tacho = cozinha.tacho - 1;

        printf("[CONVIDADO%d] Pegou 1 porcao ...\n", idConvidado);
        
        printf("O taxo agora tem %d porcoes\n", cozinha.tacho);
        
        fflush(stdout);
        
        // Libera a fila
        pthread_mutex_unlock(&cozinha.fila);

		srand(time(NULL));
		int tempo = (rand() % 4) + 2;
        sleep(tempo);
        printf("[C%d] Comeu 1 porcao em %d segundos...\n", idConvidado, tempo);
	}
	
    return NULL;
}

int main()
{
    pthread_t threads[NUMERO_CONVIDADOS + 1];
    
    int id[NUMERO_CONVIDADOS + 1], i;
    
    // inicializa o fila
    pthread_mutex_init(&cozinha.fila, NULL);

	// inicializa os semaforos
    sem_init(&cozinha.CHEIO, 0, 0);
    sem_init(&cozinha.VAZIO, 0, 0);
    
    // cria os consumidores
    for (i = 0; i < NUMERO_CONVIDADOS; i++) {
        // cria um novo consumidor
        id[i] = i;
        printf("Convidado %d chegou\n", i);
        pthread_create(&threads[i], NULL, convidado, (void*)&id[i]);
    }
    
    // cria o cozinheiro
    id[i] = i;
    printf("Cozinheiro %d comecou a trabalhar\n", i);
    pthread_create(&threads[i], NULL, cozinheiro, (void*)&id[i]);
    
    for (i = 0; i < NUMERO_CONVIDADOS; i++)
        pthread_join(threads[i], NULL);


}
