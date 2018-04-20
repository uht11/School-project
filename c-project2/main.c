#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define LINE_LENGTH 300

struct clip *build_a_lst();
struct clip *append();
int find_length();
void print_lst();
void split_line();

struct clip {
    int views;
    char *user;
    char *time;
    char *id;
    char *title;
    struct clip *next;
} *head;

int main(int argc, char **argv) {
    int n;
    head = build_a_lst(*(argv+1));
    n = find_length(head);
    printf("%d clips\n", n);
    print_lst(head);
    return 0;
}

struct clip *build_a_lst(char *fn) {
    FILE *fp;
    struct clip *hp;
    char *fields[5];
    char line[LINE_LENGTH];
    int cnt=0;
    hp=NULL;

    fp = fopen(fn, "r");
    
    while (fgets(line, LINE_LENGTH, fp) != NULL) 
    {
        split_line(fields, line);
        hp = append(hp, fields);
    }
    fclose(fp);
    
    return hp;
}


void split_line(char **fields, char *line) {
    int i = 0;
    char *token, *delim;
    delim = ",\n";

    token = strtok(line, delim);
    fields[i] = malloc(strlen(token));
    strcpy(fields[i], token);
    i++;

    while (token) 
    {
        token = strtok(NULL, delim);
        if (token != NULL) 
        {
            fields[i] = malloc(strlen(token));
            strcpy(fields[i], token);
            i++;
        }
    }
}

struct clip *append(struct clip* hp, char **five) {
    struct clip* cp;
    struct clip* tp;

    cp = hp;
    tp = NULL;

    tp = malloc(sizeof(struct clip));
    tp->next = NULL;

    tp->user = malloc(sizeof(five[0]));
    strcpy(tp->user, five[0]);
    
    tp->views = atoi(five[1]);

    tp->time = malloc(sizeof(five[2]));
    strcpy(tp->time, five[2]);

    tp->id = malloc(sizeof(five[3]));
    strcpy(tp->id, five[3]);

    tp->title = malloc(sizeof(five[4]));
    strcpy(tp->title, five[4]);
    
    if (cp == NULL) {
        hp = tp;
    }
    else 
    {
        while (cp->next != NULL) 
            cp = cp->next;
        
        cp->next = tp;
    }
    return hp;
}


int find_length(struct clip *hp) {
    int count = 0;
    struct clip* cp = hp;
    while (cp) 
    {
        count++;
        cp = cp->next;
    }
    return count;
}

void print_lst(struct clip* cp) {

    cp=head;
    while (cp != NULL) {
        printf("%s, %i, %s, %s, %s\n", cp->user, cp->views, cp->time, cp->id, cp->title);
         cp= cp->next;
    }
}