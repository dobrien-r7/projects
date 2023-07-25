# 
#
#



#### IMPORTS
import click

# Main
@click.command()
@click.argument('option')
@click.option('--write', '-w')
def main(option, todo):
    if option == 'r':
        readFile()
    elif option == 'w':
        writeFile(todo)

if __name__ == "__main__":
    main()

def readFile():
    ###Read current file
    file = open("todos.txt", "r")

    #print(file.read())
    currentTodos = []
    for line in file:
        currentTodos.append(line)
    file.close()
    print(currentTodos)

def writeFile(newTodo):
    ###Write to file
    file = open("todos.txt", "a")
    file.write(newTodo)
    file.close()

