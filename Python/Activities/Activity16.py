class Car:
    'Car class'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color
    
    def accelerate(self):
        print("{Manufacturer}: ", self.manufacturer,"{Model}: ", self.model, "is moving")

    def stop(self):
        print("{Manufacturer}: ", self.manufacturer,"{Model}: ", self.model, "has stopped")  

c1= Car("manufacturer1", "model1", "make1", "transmission1", "color1")
c2= Car("manufacturer2", "model2", "make2", "transmission2", "color2")
c3= Car("manufacturer3", "model3", "make3", "transmission3", "color3")

c1.accelerate()
c1.stop()
c2.accelerate()
c2.stop()
c3.accelerate()
c3.stop()