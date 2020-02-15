# Ticking Circus

Hour, minute and second hand are represented by the clown, man and woman icon.
User could set alarm time with moving flag icon. Get a preview here [Click me!](https://codepen.io/Debra/pen/NpPgxQ)

## Getting Started

Developing environment is Eclipse IDE for Java Developers Version: Neon.1a Release (4.6.1). 
jmf-2.1.1e.jar has to be specified manually in 
```
Project > Properties > Java Build Path > Add JARs.
```

## Software Design 

SecondHand, minuteHand hourHand and alarmHand are separated to be 4 classes with the same father class. 
This design allows developers to work in parallel and project leader could specify essential functions in interface ClockHand. 

## License

This project is licensed under the MIT License

