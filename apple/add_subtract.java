// more parallaized addition code

int Add(int a, int b)
{
    while (b)// ex - 101 and 011 a = a^b = 110 carry = 001 we shift it by 1 bit so that the carry is available for second bit
    {
        int carry = a & b;// carry computes if a carry is possible by doing a & b on all the bits in a and b 
        a = a ^ b;// we compute the sum and store in a
        b = carry << 1;// shift the carry by 1 bit because carry formed by index 0 bits are to be added to index 1
    }
    return a;
}

// other method to add two numbers
int add(int x, int y) {
    int carry = 0;
    int result = 0;
    int i;

    for(i = 0; i < 32; ++i) {
        int a = (x >> i) & 1;// get the bit value of x at index postion i
        int b = (y >> i) & 1;//get the bit value of y at index postion i
        result |= ((a ^ b) ^ carry) << i;// compute the answer by doing xor which is basically addition without carry,also consider previous carry when adding
        carry = (a & b) | (b & carry) | (carry & a);// we get carry for 3 case when both a and b have 1 bits or carry bit is 1 and any of a or b bit is 1. So we are checking exactly the same thing to determine if a carry is possible
    }

    return result;
}

int negate(int x) {// we negate a number as decribed in 2 compliment way by complementing the whole number and adding 1
    return add(~x, 1);
}

int subtract(int x, int y) {// to subtract negate(y) and add, 
    return add(x, negate(y));
}

int is_even(int n) {
    return !(n & 1);
}

int divide_by_two(int n) {
    return n >> 1;
}

int multiply_by_two(int n) {
    return n << 1;
}