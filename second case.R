library(ggplot2)
data(mtcars)
attach(mtcars)
> plot(cyl, disp, main = "Displacement vs Cylinder ", xlab = "Cylinder", ylab = "Displacement", 
       +      pch = 15, col = "red")
> text(cyl, disp, row.names(mtcars), cex = 0.6, pos = 3, col = "blue")
