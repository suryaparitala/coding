partition(int left,int right,int pivot){


leftptr = left-1;
rightptr = right;

while(true){

while( array[++leftptr] < pivot)
;

while(array[--rightptr] > pivot)
;
if(leftptr >= rightptr)
break;

else 
 swap(leftptr,rightptr);
 }
 swap(leftptr,rigth - 1)

quicksort(int left , int right)
{

}


swap
{
temp = arr[rightptr];
arr[rightptr] = arr[leftptr];
arr[leftptr] = temp;
}

manualsort(left, right)
{
center = (left +right) / 2;
if(arr[left] > arr[center]){
 swap(left,center);
}
if(arr[center] > arr[right]){
swap(center,right);
}

if(arr[left] > arr[right]){
swap(left,right);
}

swap(center,right);

return right;

}

recquicksort(int left,int right)
{
	if(right - left == 0 )
		return;
	
	else
	{
	pivot = arr[right];
	int partition = partiton(left,right,pivot);
	recquicksort(left,partiton-1);
	recquicksort(partiton+1,right);
    }
}




}


