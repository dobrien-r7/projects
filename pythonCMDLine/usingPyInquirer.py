from __future__ import print_function, unicode_literals
from PyInquirer import prompt
from pprint import pprint
questions = [
    {
        'type': 'input',
        'name': 'first_name',
        'message': 'What\'s your first name',
     },
    {
        'type': 'input',
        'name': 'last_name',
        'message': 'What\'s your last name',
    }
]
answers = prompt(questions)
pprint(answers)