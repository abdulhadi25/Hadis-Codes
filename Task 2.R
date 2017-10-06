price=8000
for(i in 1:12)
{
  for(j in 1:12)
  {
    thirdmatrix=firstmatrix*price
  }
  price=price*1.1
}
colnames(thirdmatrix) <- c("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")
rownames(thirdmatrix) <- c("1949","1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960")
max(thirdmatrix)
month= which(thirdmatrix == max(thirdmatrix), arr.ind=TRUE)
column = colnames(thirdmatrix)[month [,2]]
row = rownames(thirdmatrix)[month[,1]]
cat("Month ",column ,"has greatest revenue",max(thirdmatrix))
fourthmatrix <- apply(t(thirdmatrix),2,cumsum)
max(fourthmatrix,12)
cat("Year ",row ,"of greatest revenue:",max(fourthmatrix,12))
sum(thirdmatrix)
cat("Total Revenue is:",sum(thirdmatrix))

