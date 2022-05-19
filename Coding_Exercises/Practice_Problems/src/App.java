import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class App {
    public static int[] twoNumberSumNaive(int[] array, int targetSum) {
        // Write your code here.
        for(int i = 0; i < array.length - 1; i++) {
            int firstNum = array[i];
            for(int j = i + 1; j < array.length; j++) {
                int secondNum = array[j];
                if(firstNum + secondNum == targetSum) {
                    return new int[] {firstNum, secondNum};
                }
            }
        }
        
        return new int[0];
        // Time: O(n^2), Space: O(n)
      }

      public static int[] twoNumberSumOptimal(int[] array, int targetSum) {
          Set<Integer> nums = new HashSet<>();

          for(int i : array) {
              int difference = targetSum - i;
              if(nums.contains(difference)) {
                  return new int[] {i, difference};
              } else {
                  nums.add(i);
              }
          }

          return new int[0];
          //Time: O(N) Space: O(N)
          //This algorithm takes advantage of the fact that if sum - xi = xj, the xi + xj = sum. For each number in the input array, If (sum - xi) has not in the set, then you store xi in a set. If there is another number xj in the input array such that sum - xj = xi, then you have found the two numbers.

          //There is a third solution that involves sorting and multiple pointers that has O(N*log(N)) time and O(N) space.
      }

      public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int pointer2 = 0;
        for(int pointer1 = 0; pointer1 < array.size() && pointer2 < sequence.size(); pointer1++) {
            //Whenever we're indexing arrays, we need to make sure we control for out of bounds indices for all arrays we work with.
            if(array.get(pointer1) == sequence.get(pointer2)) {
                pointer2++;
            }
        }
        return pointer2 == sequence.size();
        //Time: O(N) where N is the length of the array. Space: O(1).
      }

      public static int[] sortedSquaredArray(int[] array) {
        //This method must account for arrays that contain negative integers, you can't just square each element and return.
        int[] squaredInts = new int[array.length];
            
        for(int i = 0; i < array.length; i++) {
            squaredInts[i] = (int) Math.pow(array[i], 2.0);
        }
        
        Arrays.sort(squaredInts);
        return squaredInts;
        //Time: O(n*log(n)) Space: O(n).
      }

      public static int[] sortedSquaredArrayOptimal(int[] array) {
        //The optimal solution takes advantage of the fact that the array is sorted. The previous solution would work even for an unsorted array.
        int[] squaredInts = new int[array.length];

        //These two pointers track the largest number in the array. For an array that contains positives and negatives, the largest square will be at either end. Ex: [-7, -3, 1, 5, 9]. 9 is the largest square
        int start = 0;
        int end = array.length - 1;

        for(int i = array.length - 1; i >=0; i--) {
            if(Math.abs(array[start]) > Math.abs(array[end])) {
                squaredInts[i] = array[start] * array[start];
                start++;
            } else {
                squaredInts[i] = array[end] * array[end];
                end--;
            }
        }

        return squaredInts;
        //Time: O(n) Space: O(n)
      } 

      public static String tournamentWinner(
        ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        Map<String, Integer> scoreBoard = new HashMap<>();
        int AWAY_TEAM_WON = 0;
        String currentBestTeam = "";
        Integer currentBestPoints = 0;
        scoreBoard.put(currentBestTeam, currentBestPoints);
        
        for(int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);
            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);

            String winningTeam = results.get(i) == AWAY_TEAM_WON ? awayTeam : homeTeam;
            scoreBoard.putIfAbsent(winningTeam, 0);
            scoreBoard.put(winningTeam, scoreBoard.get(winningTeam) + 3);

            if(scoreBoard.get(winningTeam) > currentBestPoints) {
                currentBestTeam = winningTeam;
                currentBestPoints = scoreBoard.get(winningTeam);
            }
        }
          
        return currentBestTeam;
        //Time: O(n) where n is the number of competitions. Space: O(k) where k is the number of teams.
    }

    public static int nonConstructibleChangeBrute(int[] coins) {
        // Write your code here.
        int minimumChange = 1;
        if(coins.length == 0) {
            return minimumChange;
        }

        Arrays.sort(coins);
        
        while(true) {
            int total = minimumChange;
            for(int i = coins.length - 1; i >= 0; i--) {
                if(coins[i] <= total) {
                    total -= coins[i];
                }
                if(total == 0) {
                    break;
                }
            }
            
            if(total == 0) {
                minimumChange++;
            } else {
                return minimumChange;
            }
        }

        //Time: O(n*m) where n is the size of coins and m is the value of minimumChange.
        //Space: O(1) because we don't use additional data structures.
        //This is the brute-force solution because you incremement the minimumChange by 1, checking every possible value until you find one that doesn't work.
      }

      public static int nonConstructibleChangeOptimal(int[] coins) {
          //This solution can find the minimum impossible change by stepping through the array just one time.
          //You start with a minimum change of zero and sort the array. For each element in the sorted array, you compare the value of that element to change + 1. If it's greater than that, the minimum impossible change is 'change + 1'.
          //Example: If you don't have any pennies, the minimum amount of change you can't create is one.
          //[1, 2, 5] -> change starts at 0. 1 ~> change + 1, so change = 0 + 1. 2 ~> change + 1, so change = 1 + 2.
          //5 > change + 1 (4), so the minimum impossible change is 4.
          Arrays.sort(coins);

          int change = 0;
          for(int coin : coins) {
              if(coin > change + 1) {
                  return change + 1;
              } else {
                  change += coin;
              }
          }

          return change + 1;
      }

      public static int findClosestValueInBst(BST tree, int target) {
        // Write your code here.
        List<BST> queue = new ArrayList<>();
        queue.add(tree);
        
        int minimumDifference = Integer.MAX_VALUE;
        BST currentTree = tree;
        BST minimumTree = null;
        while(!Objects.isNull(currentTree)) {
            int value = currentTree.value;
            
            int difference = Math.abs(target - value);
            if(difference < minimumDifference) {
                minimumDifference = difference;
                minimumTree = currentTree;
                
                if(minimumDifference == 0) {
                    break;
                }
            }
            
            if(value > target) {//If the value of the current node is greater than the target value, moving right isn't efficient because it will widen the difference between the two values.
                currentTree = currentTree.left;
            }
            if(value < target) {
                currentTree = currentTree.right;
            }
            System.out.println(minimumDifference);
        }
            
        return minimumTree.value;
        //Average: Time: O(log(n)) Space: (O(1))
        //Worst: Time: O(n) Space: O(1) 
      }
    
      static class BST {
        public int value;
        public BST left;
        public BST right;
    
        public BST(int value) {
          this.value = value;
        }
        //Time: O(log(n)) Space: O(1).
      }

      public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
    
        BinaryTree(int value) {
          this.value = value;
          this.left = null;
          this.right = null;
        }
      }
    
      public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> sums = new ArrayList<>();
        postOrderTraversal(root, sums, root.value);
        return sums;
      }
        
    public static void postOrderTraversal(BinaryTree node, List<Integer> sums, int currentSum) {
        if(!Objects.isNull(node.left)) {
            postOrderTraversal(node.left, sums, currentSum + node.left.value);
        }
        if(!Objects.isNull(node.right)) {
            postOrderTraversal(node.right, sums, currentSum + node.right.value);
        }
        if(Objects.isNull(node.left) && Objects.isNull(node.right)) {
            System.out.println(currentSum);
            sums.add(currentSum);
        }

        //Time: O(n) where n is the number of nodes. Space: O(log(n)) in the average or best case (balanced binary tree). This is because you will never have more than n recursive calls on the call stack *at once*. For a skewed binary tree (worst case), the space complexity is O(n). For the list you return, the space complexity is O(n).

        //Overall: Time: O(n) Space: O(n).
    }

    public static int nodeDepths(BinaryTree root) {
        // Write your code here.
        return nodeDepthsHelper(root, 0);
        //Time: O(n) where n is the number of nodes in the binary tree.
        //Space: O(h) where h is the height of the binary tree.
    }
    
    public static int nodeDepthsHelper(BinaryTree node, int currentDepth) {
        int depthSum = currentDepth;
        if(!Objects.isNull(node.left)) {
            depthSum += nodeDepthsHelper(node.left, currentDepth + 1);
        }
        if(!Objects.isNull(node.right)) {
            depthSum += nodeDepthsHelper(node.right, currentDepth + 1);
        }
        
        return depthSum;
    }

    public static int nodeDepthsIterative(BinaryTree root) {
        // Write your code here.
        int depthSum = 0;
        List<Map<BinaryTree, Integer>> stack = new ArrayList<>();
        
        Map<BinaryTree, Integer> rootDepth = new HashMap<>();
        rootDepth.put(root, 0);
        stack.add(0, rootDepth);
        
        while(!stack.isEmpty()) {
            Map<BinaryTree, Integer> nodeDepth = stack.remove(0);
            for(Map.Entry<BinaryTree, Integer> entry : nodeDepth.entrySet()) {
                BinaryTree node = entry.getKey();
                Integer depth = entry.getValue();
                
                depthSum += depth;
                
                if(!Objects.isNull(node.left)) {
                    Map<BinaryTree, Integer> leftChildDepth = new HashMap<>();
                    leftChildDepth.put(node.left, depth + 1);
                    stack.add(0, leftChildDepth);
                }
                if(!Objects.isNull(node.right)) {
                    Map<BinaryTree, Integer> rightChildDepth = new HashMap<>();
                    rightChildDepth.put(node.right, depth + 1);
                    stack.add(0, rightChildDepth);
                }
            }
        }
        
        return depthSum;
        //Time: O(n) where n is the number of nodes in the binary tree.
        //Space: O(h) where h is the height of the binary tree.
      }

      static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();
    
        public Node(String name) {
          this.name = name;
        }
    
        public List<String> depthFirstSearch(List<String> array) {
          // Write your code here.
          traverse(this, array);
          return array;
          //Time: O(v + e) where v and e are the number of vertices and edges in the graph, respectively.
          //Space: O(v) where v is the number of vertices (this is the size of the return array). There are also v frames added to the call stack, so the complexity is O(2v) in the worst case. The worst case is a linear graph (one branch).
        }
            
        private void traverse(Node node, List<String> visited) {
            visited.add(node.name);
            
            for(int i = 0; i < node.children.size(); i++) {
                traverse(node.children.get(i), visited);
            }
        }
            
        public Node addChild(String name) {
          Node child = new Node(name);
          children.add(child);
          return this;
        }
      }

      public int minimumWaitingTime(int[] queries) {
        // Write your code here.
            if(queries.length == 1) {
                return 0;
            }
            
            Arrays.sort(queries);
            int minimumWaitingTime = 0;
            for(int i = 1; i < queries.length; i++) {
                minimumWaitingTime += queries[i - 1]*(queries.length - i);
            }
        
        return minimumWaitingTime;
            //Example of a Greedy algorithm because you make a 'greedy' choice about what to execute first.
            //We execute the shortest queries first so that the waiting time for the other queries is minimized.
            //Time: O(n*log(n)) Space: O(1)
      }

      public boolean classPhotos(
      ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
    // Write your code here. Another greedy algorithm. We sort the arrays, then look at them in descending order.
		//All students in the first array must be taller or shorter than students in the second.
		//There can't be any students of equal heights
		Collections.sort(redShirtHeights, Collections.reverseOrder());
		Collections.sort(blueShirtHeights, Collections.reverseOrder());
		
		String shirtColorInFirstRow = redShirtHeights.get(0) < blueShirtHeights.get(0) ? "RED" : "BLUE";
		for(int i = 0; i < redShirtHeights.size(); i++) {
			int redShirtHeight = redShirtHeights.get(i);
			int blueShirtHeight = blueShirtHeights.get(i);
			
			if(shirtColorInFirstRow == "RED") {
				if(redShirtHeight >= blueShirtHeight) {
					return false;
				}
			} else {
				if(blueShirtHeight >= redShirtHeight) {
					return false;
				}
			}
		}
		
		return true;
		//Time: O(n*log(n)) //Space: O(1)
	}

    public int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        // Write your code here. Another example of a greedy algorithm, where we pair the smallest number in one array to the largest number in the other array.
        //Greedy algorithms typically involve sorting the input arrays. Always sort arrays if it makes sense to do so.
        //Then, look back and refactor to see if sorting is really necessary.
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        
        int speed = 0;		
        for(int i = 0; i < redShirtSpeeds.length; i++) {
            if(fastest) {
                speed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[blueShirtSpeeds.length - (i + 1)]);
            } else {
                speed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
            }
        }
        
        return speed;
        //Time: O(n*log(n)) Space: O(1)
      }
    public static void main(String[] args) throws Exception {
        int[] nums = new int[] {5,7,1,1,2,3,22};//1,1,2,3,5,7,22
        System.out.println(nonConstructibleChangeOptimal(nums));
        System.out.println(Math.abs(-5));
    }
}
