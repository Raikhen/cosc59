import re

# File
f = open('A02/RDP/test.txt', 'r')

# Symbol table
sym_table = set()

def tokenize(input):
  # Remove all whitespace from input
  chunks = re.sub(r'\s', ' ', input).split()

  # Define the pattern for the tokens
  pattern = r'\+|\-|\*|/|\(|\)|MOD|[a-zA-Z][a-zA-Z0-9]*|\d+|\;'

  # Initialize the list of tokens
  tokens = []

  for chunk in chunks:
    while len(chunk) > 0:
      # Find first match
      match = re.search(pattern, chunk)

      # Add first match to list of tokens and remove from input
      if match != None:
        tokens.append(match.group())
      chunk = chunk[len(match.group()):]

  return tokens

def parse(tokens):
  to_print = ''

  # Terminals
  id = lambda token: re.match(r'[a-zA-Z][a-zA-Z0-9]*', token) and token != 'MOD'
  num = lambda token: re.match(r'\d+', token)

  # Non-terminals
  def factor():
    nonlocal to_print

    if len(tokens) == 0:
      raise Exception('Syntax error: Expected factor but got no tokens')
    elif tokens[0] == '(':
      tokens.pop(0)
      expr()

      if tokens[0] != ')':
        raise Exception('Syntax Error: Expected ")"')
      
      tokens.pop(0)
    elif id(tokens[0]):
      to_print += tokens[0] + ' '
      sym_table.add(tokens.pop(0))
    elif num(tokens[0]):
      to_print += tokens[0] + ' '
      tokens.pop(0)
    else:
      raise Exception(f'Syntax Error: Expected factor but got {tokens[0]}')

  def factors():
    nonlocal to_print

    if len(tokens) == 0:
      return
    elif tokens[0] == '*':
      tokens.pop(0)
      factor()
      to_print += '* '
      factors()
    elif tokens[0] == '/':
      tokens.pop(0)
      factor()
      to_print += '/ '
      factors()
    elif tokens[0] == 'MOD':
      tokens.pop(0)
      factor()
      to_print += 'MOD '
      factors()

  def term():
    factor()
    factors()

  def terms():
    nonlocal to_print

    if len(tokens) == 0:
      return
    elif tokens[0] == '+':
      tokens.pop(0)
      term()
      to_print += '+ '
      terms()
    elif tokens[0] == '-':
      tokens.pop(0)
      term()
      to_print += '- '
      terms()

  def expr():
    term()
    terms()

  # Parse the expression
  expr()
  
  if (len(tokens) != 1 or tokens[0] != ';'):
    raise Exception(f'Syntax Error: Expected ";" but got {tokens[0]}')

  print(f'{to_print[:-1]};')

# Parse every line in the file
for x in f:
  tokens = tokenize(x)

  try:
    parse(tokens)
  except Exception as e:
    print(f'Invalid input: {x.strip()[:-1]};')

# Print the symbol table
print(f'Symbol table: {', '.join(sym_table)}.')