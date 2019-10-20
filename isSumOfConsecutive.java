/* https://app.codesignal.com/challenge/X4Qpbuu8A4xiiNdc7
 *
 * Determine if a number can be expressed as a sum of some consecutive positive integers.
 *
 * Example
 * 
 * For n = 9, the output should be
 * isSumOfConsecutive(n) = true.
 * 
 * Explanation: It is possible to get n = 9 in the following way: 2 + 3 + 4 = 9.
 * 
 * For n = 8, the output should be
 * isSumOfConsecutive(n) = false.
 * 
 * Input/Output
 * 
 * [execution time limit] 3 seconds (java)
 * 
 * [input] integer n
 * 
 * Guaranteed constraints:
 * 1 ≤ n ≤ 1000.
 * 
 * [output] boolean
 * 
 * true if it is possible to express n as a sum of some (at least two) consecutive positive integers, false otherwise.
 */

boolean isSumOfConsecutive(int n) {
    // Set up storage for a partial sum of the consecutive integers we're looking at and which integer we're on
    int sum, counter;
    // Loop through integers from 1 to half of the target sum because, at the largest, the consecutive numbers
    // that will add up to the target number will be the two middle numbers in the sequence from 1 to n -- for example,
    // 4 + 5 = 9. Beyond that, consecutive integers are going to add up to more than the target.
    for (int i = 1; i < n/2; i++)
    {
        sum = 0; // Reset the partial sum
        counter = i; // Start adding numbers at the current position of the loop
        // If our partial sum gets to equal more than the target number, then we know there isn't a sequence starting
        // with the integer i that adds up to the target n. In that case, move on and look at sequences starting with
        // the next integer.
        while (sum < n)
        {
            sum += counter; // Add the number we're on to the current partial sum
            if (sum == n) // Check if our sum has hit the target
                return true; // If so, we're done, and we return true
            counter++; // Otherwise, get ready to add the next integer in the sequence
        }
    }
    // If we went through the integers from 1 to n/2 and didn't find a sequence of consecutive integers that adds up
    // to the target n, then we can be sure that there is no such sequence, and we can return false.
    return false;
}
