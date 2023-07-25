#!/usr/bin/env python
import csv
 
tasks = 'tasks.csv'
action = ''
done = 'NO'
 
while done == 'NO' or done =='no': 
    while action not in ('SHOW OPEN', 'SHOW CLOSED', "UPDATE", "ADD", "READ"):
        action = input('You must choose either: ADD or READ ')
 
    if action == 'SHOW OPEN' or action == 'READ':
        showOpen()
        done = input('Are you done (YES or NO)')
    elif action == 'SHOW CLOSED':
        showClosed()
        done = input('Are you done (YES or NO)')
    elif action == 'UPDATE' or action == 'ADD':
        showOpen()
        id_update = input('Which Task ID to Update')
        id_update = str(1)
        update_field = input('DESCRIPTION, DATE or STATUS update?')
        update_value = input('New Value')
        updateTask(id_update, update_field, update_value)
        done = input('Are you done (YES or NO)')
    else:
        done = input('Are you done (YES or NO)')
         
def showOpen():
    with open(tasks) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        for row in csv_reader:
            if 'complete' not in row:
                print(row)
             
def showClosed():
    with open(tasks) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
        for row in csv_reader:
            if 'complete' in row:
                print(row)    
             
def updateTask(id, field, update_value):
    with open(tasks) as csv_file:
        csv_reader = csv.reader(csv_file, delimiter=',')
         
        x = []
        for row in csv_reader:
            if row[0] == id:
                if field == 'DESCRIPTION':
                    row[1] = update_value
                elif field == 'DATE':
                    row[2] = update_value
                elif field == 'STATUS':
                    row[3] = update_value
            x.append(row)
            writeback(x)
             
def writeback(x):
    with open('tasks.csv', 'w') as writeFile:
        writer = csv.writer(writeFile)
        writer.writerows(x)