library(ggplot2)
data(mtcars)
attach(mtcars)
plot(hp, disp, main = "Horsepower vs Displacement", xlab = "Horsepower", ylab = "Displacement", 
     +      pch = 15, col = "orange")
> text(hp, disp, row.names(mtcars), cex = 0.6, pos = 4, col = "red")
