#include <stdio.h>
#include <string.h>

int lineNum=3, argcSize;
int *pp;
char getMem[8];
int addition;

void printStratingLines(){
    printf("\t+-------+-------+-------+-------+ FFFFFFFF");
    printf("\n\t+-------+-------+-------+-------+");
    printf("\n\t+-------+-------+-------+-------+\n\t|\t|");

}

void printEndingLines(){
    printf("\t+-------+-------+-------+-------+");
    printf("\n\t+-------+-------+-------+-------+");
    printf("\n\t+-------+-------+-------+-------+");
    printf("\n\t+-------+-------+-------+-------+\n 00000000");

}

void printInbetweenLines()
{
    printf("\t+-------+-------+-------+-------+");
    printf("\n\t+-------+-------+-------+-------+");
    printf("\n\t+-------+-------+-------+-------+\n");
    printf("\t+-------+-------+-------+-------+\n");
}

void createTable(char c)
{
    printf("%c\t|", c );

    if(lineNum ==0)
    {
        lineNum=4;
        printf(" %x\n\t|+------+-------+-------+-------+\n\t",addition+(argcSize*4));
        addition-=4;
        pp++;
    }

}

int main(int argc, char **argv)
{
	argcSize=argc;
	pp=*&argv[0];
	addition=(int)pp;
    printStratingLines();
    int i, a;
    
    for(i=argc-1; i>=0; i--)
    {
        int count = 0;
        printf("\\0");

        for(a=0; argv[i][a] != '\0'; a++)
            count++;
        
        while( count >=0 )
        {

            lineNum--;
            createTable(argv[i][count]);
            count--;
            printf("   ");

        }
    }
    printf("\n");
    printInbetweenLines();
    
    char argvAddress[8];
    int *temp=&argv[0];
    int *temp2=&argc-2;
    int *temp3=&argv[argc+1];


    
    char argvAdd[8];
    int *extraArgC=&argv[argc+1];
    extraArgC++;
    extraArgC++;
    int *finalprinting=extraArgC;
    finalprinting++;
    printf("\t|\t|\t|\t|\t| %x\n", finalprinting);
    printf("\t+-------+-------+-------+-------+\n");
    printf("argv+%d\t|00\t|00\t|00\t|00\t| %x\n",argc+1, extraArgC);
    printf("\t+-------+-------+-------+-------+\n");
    printf("\t+-------+-------+-------+-------+\n");
    for(i=argc-1; i >=0; i--)
    {
        sprintf(argvAdd, "%x", argv[i]);
        printf("argv+%d\t|", i);
	int a;
        for(a=0; a< 8; a+=2)
        {
            printf("%c%c\t|", argvAdd[a], argvAdd[a+1]);
        }
        printf(" %x\n\t+-------+-------+-------+-------+\n\t", &argv[i]);
        printf("+-------+-------+-------+-------+\n");
    }
//--------------------------//
    printInbetweenLines();

    sprintf(argvAddress, "%x", temp);
    printf("argc\t|00\t|00\t|00\t|0%d\t| %x\n", argc, &argc);    
    printf("\t+-------+-------+-------+-------+");
    printf("\n\t+-------+-------+-------+-------+\n");
    
    printf("argv\t|");
    for(i=0; i<8; i=i+2)
    {
        printf("%c%c\t|", argvAddress[i], argvAddress[i+1]);
        getMem[i]=argvAddress[i];
        getMem[i+1]=argvAddress[i+1];
    }

    printf(" %x\n", temp2);

    printEndingLines();
}