#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Student
{
    int regNum;
    char name[100];
    int class;
    struct Student *next;
} Student;

Student *hashTable[100];

int hash(int rNo)
{
    return rNo % 100;
}

void addStudent(int regNum, char *name, int class)
{
    int index = hash(regNum);
    Student *newS = (Student *)malloc(sizeof(Student));
    newS->regNum = regNum;
    strcpy(newS->name, name);
    newS->class = class;
    newS->next = NULL;

    if (hashTable[index] == NULL)
    {
        hashTable[index] = newS;
    }
    else
    {
        Student *temp = hashTable[index];
        while (temp->next != NULL)
        {
            if (temp->regNum == regNum)
            {
                printf("Student with Register Number %d already exists.\n", regNum);
                free(newS);
                return;
            }
            temp = temp->next;
        }
        temp->next = newS;
    }

    printf("Student added successfully!\n");
}

Student *searchStudent(int regNum)
{
    int index = hash(regNum);
    Student *temp = hashTable[index];
    while (temp != NULL)
    {
        if (temp->regNum == regNum)
        {
            return temp;
        }
        temp = temp->next;
    }
    return NULL;
}

void deleteStudent(int regNum)
{
    int index = hash(regNum);
    Student *temp = hashTable[index];
    Student *prev = NULL;

    while (temp != NULL)
    {
        if (temp->regNum == regNum)
        {
            if (prev == NULL)
            {
                hashTable[index] = temp->next;
            }
            else
            {
                prev->next = temp->next;
            }
            free(temp);
            printf("Student deleted successfully!\n");
            return;
        }
        prev = temp;
        temp = temp->next;
    }

    printf("Student with Register Number %d not found.\n", regNum);
}

void updateStudent(int regNum, char *newName, int newClass, Student *student)
{
    strcpy(student->name, newName);
    student->class = newClass;
    printf("Student updated successfully!\n");
}

void menu()
{
    int choice, regNum, class;
    char name[100];

    do
    {
        printf("\nStudent Management System:\n");
        printf("1. Add Student\n");
        printf("2. Search Student\n");
        printf("3. Delete Student\n");
        printf("4. Update Student\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            printf("Enter Register Number: ");
            scanf("%d", &regNum);
            printf("Enter Name: ");
            scanf("%s", name);
            printf("Enter Class: ");
            scanf("%d", class);
            addStudent(regNum, name, class);
            break;
        case 2:
            printf("Enter Register Number to Search: ");
            scanf("%d", &regNum);
            Student *student = searchStudent(regNum);
            if (student != NULL)
            {
                printf("Student Found:\n");
                printf("Register Number: %d\n", student->regNum);
                printf("Name: %s\n", student->name);
                printf("Class: %d\n", student->class);
            }
            else
            {
                printf("Student with Register Number %d not found.\n", regNum);
            }
            break;
        case 3:
            printf("Enter Register Number to Delete: ");
            scanf("%d", &regNum);
            deleteStudent(regNum);
            break;
        case 4:
            printf("Enter Register Number to Update: ");
            scanf("%d", &regNum);
            Student *s = searchStudent(regNum);
            if (s == NULL)
            {
                printf("Student with Register Number %d not found.\n", regNum);
                break;
            }
            printf("Enter New Name: ");
            scanf("%s", name);
            printf("Enter New Class: ");
            scanf("%d", &class);
            updateStudent(regNum, name, class, s);
            break;
        case 5:
            printf("Exiting...\n");
            break;
        default:
            printf("Invalid choice. Please try again.\n");
        }
    } while (choice != 5);
}

int main()
{
    for (int i = 0; i < 100; i++)
        hashTable[i] = NULL;

    menu();

    return 0;
}
