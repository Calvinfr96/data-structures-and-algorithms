function countZeroes(array){
    //Problem: Write a function that, given an array of 1's and 0's where all 1's come before all 0's, returns the number of zeroes
    //in the array.

    //Example: countZeroes([1,1,1,1,0,0]) // 2

    //Breakdown:
    // Step 1: Create a variable called zeroCount and set it equal to zero.
    // Step 2: Create a variable called end and set equal to one less than the array length.
    // Step 3: Write a for loop where i starts at end and decrements until i=0.
    // Step 4: Within the loop, if array[i] equals zero, increment zeroCount. Otherwise, break out of the loop.

    //Solve:
    let zeroCount = 0;
    const end = array.length - 1;
    for(let i = end; i >= 0; i--) {
        if(array[i] === 0) {
            zeroCount++;
        } else {
            break;
        }
    }
    
    return zeroCount;
  }

  function sortedFrequency(array, target) {
      //Problem: Write a function that, given a sorted array of integers and an integer, returns the frequency of the integer in the array.

      //Examples: sortedFrequency([1,1,2,2,2,2,3], 2) // 4

      //Breakdown:
      // Step 1: Create a variable called count and set it equal to zero.
      // Step 2: Iterate through the array from the beginning using a for... of loop.
      // Step 3: Inside of the loop, create a variable called prev and set it equal to count.
      // Step 4: If the current element eqauls target, increment the count.
      // Step 5: Create a variable called after and set equal to count.
      // Step 6: If the counter doesn't equal zero and prev equals after, break out of the loop.

      //Solve:
      let counter = 0;

      for(let int of array) {
          const prev = counter;
          if(int === target) {
              counter++;
          }
          const after = counter;

          if(counter !== 0 && prev === after) {
              break;
          }
      }

      if(counter === 0) return -1;
      return counter;
  }

  function findRotatedIndex(array, value, low, high) {
      //Problem: Write a function that, given a rotated array of sorted integers and an integer, returns the index
      //of that integer, if found, or -1 if not found.

      //Example: findRotatedIndex([3,4,1,2],4) // 1

      //Breakdown:

      //Solve:
      if(low > high) {
          return -1;
      }

      let middle = Math.floor((low + high) / 2)
      if(array[middle] === value) {
          return middle;
      }

      if(array[low] <= array[middle]) { //left half is sorted
          if(array[low] <= value && array[middle] >= value) {
              return findRotatedIndex(array, value, low, middle - 1);
          } else {
              return findRotatedIndex(array, value, middle + 1, high);
          }
      } else if(array[middle] < array[high]) { //right half is sorted
          if(array[middle] <= value && array[high] >= value) {
              return findRotatedIndex(array, value, middle + 1, high);
          } else {
              return findRotatedIndex(array, value, low, middle - 1);
          }
      }
  }

  console.log( findRotatedIndex([3,4,1,2],4,0,3))