import turtle

def first(n):
    turtle.left(90)
    turtle.penup()
    turtle.forward(n)
    turtle.right(135)
    turtle.pendown()
    side=n*2**(1/2)
    for i in range(4):
        turtle.forward(side)
        turtle.right(90)
    turtle.penup()
    turtle.goto(0,0)
    turtle.left(45)

def second(s):
    line=2*s
    turtle.backward(s)
    turtle.pendown()
    turtle.forward(line)
    turtle.penup()
    turtle.left(135)
    turtle.forward(s*2**(1/2))
    turtle.left(135)
    turtle.pendown()
    turtle.forward(line)
    turtle.penup()
    turtle.goto(0,0)
    turtle.left(90)

def  third(s):
    first(s)
    first(s/2)
    second(s/2)

third(100)
turtle.done()

    