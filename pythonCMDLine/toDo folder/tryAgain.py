import csv
from operator import truediv
import pandas as pd

action = ''
tasks = './tasks.csv'
prompt = 'Write or read tasks or exit? w/r/x '

def main():
    """
    This is the main method
    """
    if file_has_contents():
        action = input(prompt)
        while action == 'w' or action == 'r':
            if action == 'r':
                read_what = input(' Read open = o \n Read closed = c \n Read all = a \n Input now: ')
                if read_what == 'a':
                    read_tasks()
                elif read_what == 'o':
                    read_open_tasks()
                elif read_what == 'c':
                    read_closed_tasks()
                action = input(prompt)
            elif action == 'w':
                task = input('Write task in the format [task], [status] ')
                write_task(task)
                action = input(prompt)
            elif action == 'x':
                break

    else:
        print("File doesn't contain tasks yet, nothing to read. ")

    
def write_task(task):
    with open(tasks, 'a') as my_tasks:
        my_tasks.write(task)

def read_tasks():
    # with open(tasks, 'r') as csv_file:
    #     csv_reader = csv.reader(csv_file, delimiter=',')
    #     for row in csv_reader:
    #         print(','.join(row))
    allTasks = pd.read_csv(tasks)
    print(allTasks)
    #format the printing into a dataframe

def read_open_tasks():
    with open(tasks) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        for row in csv_reader:
            if 'complete' not in row:
                print('\n'.join(row)) 
             
def read_closed_tasks():
    with open(tasks) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        for row in csv_reader:
            if 'complete' in row:
                print('\n'.join(row))   

def file_has_contents():
    rowcount  = 0
    #iterating through the whole file
    for row in open(tasks):
        rowcount+= 1
    if rowcount > 0:
        return True
    else:
        return False

if __name__ == "__main__":
    main()