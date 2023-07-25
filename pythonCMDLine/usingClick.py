# cli.py
import click

@click.command()
@click.argument('name')
@click.option('--greeting', '-g')
def main(name, greeting):
    click.echo("{}, {}".format(greeting, name))

if __name__ == "__main__":
    main()

#greeting, to use press play in top right
# then use flag --greeting (greeting) (name)
# so --greeting (hello) (you)


