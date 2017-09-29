library(ggplot2)
data(mtcars)
attach(mtcars)
plot(cyl, mpg, main = "Cyl vs MPG", xlab = "Cylinder Size", ylab = "Mileage", 
     +      pch = 15, col = "purple")
text(cyl, mpg, row.names(mtcars), cex = 0.6, pos = 4, col = "blue")
