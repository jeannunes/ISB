#include <stdio.h>      /* printf, fgets */
#include <stdlib.h>     /* atoi */

#define true 1
#define false 0
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

typedef struct memoriaFifo {
	struct memoriaFifo *prox;
	int valor;
} memoriaFifo;

int main(int argc, char** argv) {
	
	int frames = 4;
	memoriaFifo *memoria[frames];
	
	char diretorio[100] = "D:\\OneDrive - Grupo Marista\\5º Periodo\\SO\\FIFO\\Files\\arquivo1.txt";
	int paginas;
	int numLido;
	char info[10];
	
	struct memoriaFifo inicio, prt, aux;
	
	int i;
	for(i = 0; i < frames; i++){
		int pos = i + 1;
		if (pos == frames)
			pos = 0;
		memoriaFifo *temp = malloc(sizeof(memoriaFifo));
		temp->prox = memoria[pos];
		temp->valor = i + 10;
		memoria[i] = temp;
	}
	
	FILE *arquivo;
	if ((arquivo = fopen(diretorio, "r")) == NULL){
		printf("Erro ao abrir arquivo!!!\n\n");
		exit(1);
		return;
	}
	
	memoriaFifo ultimo;
	ultimo = memoria[0];
	
	while (!feof(arquivo))
	{
		fgets(info, 9, arquivo);
		if (!feof(arquivo)){
			numLido = atoi(info);
			paginas += 1;
			ultimo->valor = numLido;
			ultimo = ultimo->prox;
			printf("\n Numero lido: %d", numLido);
		}
	}
	fclose(arquivo);

	return 0;
}
