> data("AirPassengers")
> AirPassengers
> firstmatrix <- matrix(AirPassengers, nrow=12,byrow=TRUE)
> colnames(firstmatrix) <- c("Jan","Feb","Mar","Apr","May","June","Jul","Aug","Sep","Oct","Novr","Decr")
> rownames(firstmatrix) <- c("1949","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960")
> max(firstmatrix)
[1] 622
> month= which(firstmatrix == max(firstmatrix), arr.ind=TRUE)
> column = colnames(firstmatrix)[month [,2]]
> row = rownames(firstmatrix)[month [,1]]
> apply(t(firstmatrix),2,cumsum)
> secondmatrix <- apply(t(firstmatrix),2,cumsum) 
> max(secondmatrix,12)
[1] 5714
> ts.plot(AirPassengers)
