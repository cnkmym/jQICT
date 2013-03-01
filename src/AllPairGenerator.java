import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AllPairGenerator {
        private Random r = new Random(0);

        private int numberParameters = 0;
        private int numberParameterValues = 0;
        private int numberPairs = 0;
        private int poolSize = 20; // number of candidate testSet arrays to
                                   // generate
        // before picking one to add to testSets List

        private int[][] legalValues = null; // in-memory representation of input
                                            // file as
        // ints
        private String[] parameterValues = null; // one-dimensional array of all
        // parameter values
        private int[][] allPairsDisplay = null; // rectangular array; does not
                                                // change,
        // used to generate unusedCounts array
        private List<int[]> unusedPairs = null; // changes
        private int[][] unusedPairsSearch = null; // square array -- changes
        private int[] parameterPositions = null; // the parameter position for a
                                                 // given
        // value
        private int[] unusedCounts = null; // count of each parameter value in
        // unusedPairs List
        private List<int[]> testSets = null; // the main result data structure

        public void getParameters(List<AllPairFactor> factors) {
                // NOT implemented yet
        }

        public void getParametersFromFile(String file) throws IOException {
                // string file = "..\\..\\test.txt";
                // String file = "src/testData.txt";
                // string file = "..\\..\\test-mathy.txt";
                // string file = "..\\..\\s1.txt";
                // string file = "..\\..\\s2.txt";
                // string file = "..\\..\\s3.txt";
                // string file = "..\\..\\s4.txt";
                // string file = "..\\..\\s5.txt";
                // string file = "..\\..\\s6.txt";
                // string file = args[0];
                // string file = "..\\..\\ThreeParams.txt";

                // System.out.println("\nBegin pair-wise testset generation\n");
                // System.out.println("\nInput file = " + file + "\n");

                // do a preliminary file read to determine number of parameters
                // and
                // number of parameter values
                FileReader fs = new FileReader(file);
                BufferedReader sr = new BufferedReader(fs);
                String line;
                while ((line = sr.readLine()) != null) {
                        ++numberParameters;
                        String[] lineTokens = line.split(":");
                        String[] strValues = lineTokens[1].split(",");
                        numberParameterValues += strValues.length;
                }

                System.out.println("There are " + numberParameters
                                + " parameters");
                System.out.println("There are " + numberParameterValues
                                + " parameter values");

                // now do a second file read to create the legalValues array,
                // and
                // the parameterValues array
                // fs.Position = 0;
                sr.close();
                fs.close();

                fs = new FileReader(file);
                sr = new BufferedReader(fs);

                legalValues = new int[numberParameters][];
                parameterValues = new String[numberParameterValues];
                int currRow = 0;
                int kk = 0; // points into parameterValues
                while ((line = sr.readLine()) != null) {
                        String[] lineTokens = line.split(":"); // separate
                                                               // parameter
                                                               // name from
                                                               // parameter
                                                               // values (as
                                                               // strings at
                                                               // this point)
                        String[] strValues = lineTokens[1].split(","); // pull
                                                                       // out
                                                                       // the
                                                                       // individual
                                                                       // parameter
                                                                       // values
                                                                       // into
                                                                       // an
                                                                       // array
                        int[] values = new int[strValues.length]; // create
                                                                  // small row
                                                                  // array for
                                                                  // legalValues

                        for (int i = 0; i < strValues.length; ++i) // trim
                                                                   // whitespace
                        {
                                strValues[i] = strValues[i].trim();
                                values[i] = kk;
                                parameterValues[kk] = strValues[i];
                                ++kk;
                        }

                        legalValues[currRow++] = values;
                        // for (int i = 0; i < values.length; ++i)
                        // {
                        // values[i] = kk; // map
                        // parameterValues[kk] =
                        // }

                } // while

                sr.close();
                fs.close();

                System.out.println("\nParameter values: ");
                for (int i = 0; i < parameterValues.length; ++i) {
                        System.out.print(parameterValues[i] + " ");
                }
                System.out.println("");

                System.out.println("\nLegal values internal representation: ");
                for (int i = 0; i < legalValues.length; ++i) {
                        System.out.print("Parameter" + i + ": ");
                        for (int j = 0; j < legalValues[i].length; ++j) {
                                System.out.print(legalValues[i][j] + " ");
                        }
                        System.out.println("");
                }
        }

        private void initializePairs() {
                // determine the number of pairs for this input set
                for (int i = 0; i <= legalValues.length - 2; ++i) {
                        for (int j = i + 1; j <= legalValues.length - 1; ++j) {
                                numberPairs += (legalValues[i].length * legalValues[j].length);
                        }
                }
                System.out.println("\nThere are " + numberPairs + " pairs ");

                // process the legalValues array to populate the allPairsDisplay
                // &
                // unusedPairs & unusedPairsSearch collections
                allPairsDisplay = new int[numberPairs][2]; // rectangular array;
                                                           // does not change
                unusedPairs = new ArrayList<int[]>(); // List of pairs which
                                                      // have
                                                      // not yet been captured
                unusedPairsSearch = new int[numberParameterValues][numberParameterValues]; // square
                                                                                           // array
                                                                                           // --
                                                                                           // changes

                int currPair = 0;
                for (int i = 0; i <= legalValues.length - 2; ++i) {
                        for (int j = i + 1; j <= legalValues.length - 1; ++j) {
                                int[] firstRow = legalValues[i];
                                int[] secondRow = legalValues[j];
                                for (int x = 0; x < firstRow.length; ++x) {
                                        for (int y = 0; y < secondRow.length; ++y) {
                                                allPairsDisplay[currPair][0] = firstRow[x]; // pair
                                                                                            // first
                                                                                            // value
                                                allPairsDisplay[currPair][1] = secondRow[y]; // pair
                                                                                             // second
                                                                                             // value

                                                int[] aPair = new int[2];
                                                aPair[0] = firstRow[x];
                                                aPair[1] = secondRow[y];
                                                unusedPairs.add(aPair);

                                                unusedPairsSearch[firstRow[x]][secondRow[y]] = 1;

                                                ++currPair;
                                        } // y
                                } // x
                        } // j
                } // i

                // System.out.println("allPairsDisplay array:");
                // for (int i = 0; i < numberPairs; ++i)
                // {
                // System.out.println(i + " " + allPairsDisplay[i, 0] + " " +
                // allPairsDisplay[i, 1]);
                // }

                // System.out.println("unusedPairs array:");
                // for (int i = 0; i < numberPairs; ++i)
                // {
                // if (unusedPairs[i] != null)
                // {
                // System.out.println(i + " " + unusedPairs[i][0] + " " +
                // unusedPairs[i][1]);
                // }
                // }

                // System.out.println("unusedPairs List<>:");
                // for (int i = 0; i < unusedPairs.Count; ++i)
                // {
                // int[] curr = unusedPairs[i];
                // System.out.println(i + " " + curr[0] + " " + curr[1]);
                // }

                // System.out.println("allPairsSearch array:");
                // for (int row = 0; row < numberParameterValues; ++row)
                // {
                // for (int col = 0; col < numberParameterValues; ++col)
                // {
                // System.out.print(allPairsSearch[row, col] + " ");
                // }
                // System.out.println("");
                // }

                // process legalValues to populate parameterPositions array
                parameterPositions = new int[numberParameterValues]; // the
                                                                     // indexes
                                                                     // are
                                                                     // parameter
                                                                     // values,
                                                                     // the cell
                                                                     // values
                                                                     // are
                                                                     // positions
                                                                     // within a
                                                                     // testSet
                int k = 0; // points into parameterPositions
                for (int i = 0; i < legalValues.length; ++i) {
                        int[] curr = legalValues[i];
                        for (int j = 0; j < curr.length; ++j) {
                                parameterPositions[k++] = i;
                        }
                }
                // System.out.println("parameterPositions:");
                // for (int i = 0; i < parameterPositions.length; ++i)
                // {
                // System.out.print(parameterPositions[i] + " ");
                // }
                // System.out.println("");

                // process allPairsDisplay to determine unusedCounts array
                unusedCounts = new int[numberParameterValues]; // inexes are
                                                               // parameter
                                                               // values,
                                                               // cell values
                                                               // are
                                                               // counts of how
                                                               // many times the
                                                               // parameter
                                                               // value
                                                               // apperas in the
                                                               // unusedPairs
                                                               // collection
                for (int i = 0; i < allPairsDisplay[0].length; ++i) {
                        ++unusedCounts[allPairsDisplay[i][0]];
                        ++unusedCounts[allPairsDisplay[i][1]];
                }

                // System.out.println("unusedCounts: ");
                // for (int i = 0; i < unusedCounts.length; ++i)
                // {
                // System.out.print(unusedCounts[i] + " ");
                // }
                // System.out.println("");

        }

        private void computeTestSets() {
                // ==============================================================================================================
                testSets = new ArrayList<int[]>(); // primary data structure
                System.out.println("\nComputing testsets which capture all possible pairs . . .");
                while (unusedPairs.size() > 0) // as long as ther are unused
                                               // pairs
                                               // to
                                               // account for . . .
                {
                        int[][] candidateSets = new int[poolSize][]; // holds
                                                                     // candidate
                                                                     // testSets

                        for (int candidate = 0; candidate < poolSize; ++candidate) {
                                int[] testSet = new int[numberParameters]; // make
                                                                           // an
                                                                           // empty
                                                                           // candidate
                                                                           // testSet

                                // pick "best" unusedPair -- the pair which has
                                // the sum of
                                // the most unused values
                                int bestWeight = 0;
                                int indexOfBestPair = 0;
                                for (int i = 0; i < unusedPairs.size(); ++i) {
                                        int[] curr = unusedPairs.get(i);
                                        int weight = unusedCounts[curr[0]]
                                                        + unusedCounts[curr[1]];
                                        if (weight > bestWeight) {
                                                bestWeight = weight;
                                                indexOfBestPair = i;
                                        }
                                }

                                // // pick best unusedPair, starting at a random
                                // index --
                                // does not seem to help any
                                // int bestWeight = 0;
                                // int indexOfBestPair = 0;
                                // int currIndex = r.Next(unusedPairs.Count);
                                // for (int ct = 0; ct < unusedPairs.Count;
                                // ++ct) // count
                                // is predetermine
                                // {
                                // if (currIndex == unusedPairs.Count - 1) // if
                                // at end of
                                // unusedPairs, jump to beginnng
                                // {
                                // currIndex = 0;
                                // }
                                // int[] curr = unusedPairs[currIndex];
                                // int weight = unusedCounts[curr[0]] +
                                // unusedCounts[curr[1]];
                                // if (weight > bestWeight)
                                // {
                                // bestWeight = weight;
                                // indexOfBestPair = currIndex;
                                // }
                                // ++currIndex;
                                // }

                                int[] best = new int[2]; // a copy is not
                                                         // strictly necesary
                                                         // here
                                System.arraycopy(
                                                unusedPairs.get(indexOfBestPair),
                                                0,
                                                best,
                                                0,
                                                unusedPairs.get(indexOfBestPair).length);
                                // unusedPairs[indexOfBestPair].CopyTo(best, 0);

                                // System.out.println("Best pair is " + best[0]
                                // + ", " +
                                // best[1] + " at " + indexOfBestPair +
                                // " with weight " +
                                // bestWeight);

                                int firstPos = parameterPositions[best[0]]; // position
                                                                            // of
                                                                            // first
                                                                            // value
                                                                            // from
                                                                            // best
                                                                            // unused
                                                                            // pair
                                int secondPos = parameterPositions[best[1]];

                                // System.out.println("The best pair belongs at positions "
                                // + firstPos + " and " + secondPos);

                                // generate a random order to fill parameter
                                // positions
                                int[] ordering = new int[numberParameters];
                                for (int i = 0; i < numberParameters; ++i)
                                        // initially all in order
                                        ordering[i] = i;

                                // put firstPos at ordering[0] && secondPos at
                                // ordering[1]
                                ordering[0] = firstPos;
                                ordering[firstPos] = 0;

                                int t = ordering[1];
                                ordering[1] = secondPos;
                                ordering[secondPos] = t;

                                // shuffle ordering[2] thru ordering[last]
                                for (int i = 2; i < ordering.length; i++) // Knuth
                                                                          // shuffle.
                                                                          // start
                                                                          // at
                                                                          // i=2
                                                                          // because
                                                                          // want
                                                                          // first
                                                                          // two
                                                                          // slots
                                                                          // left
                                                                          // alone
                                {
                                        int j = r.nextInt(ordering.length - i);

                                        int temp = ordering[j];
                                        ordering[j] = ordering[i];
                                        ordering[i] = temp;
                                }

                                // System.out.println("Order: ");
                                // for (int i = 0; i < ordering.length; ++i)
                                // System.out.print(ordering[i] + " ");
                                // System.out.println("");
                                // Console.ReadLine();

                                // place two parameter values from best unused
                                // pair into
                                // candidate testSet
                                testSet[firstPos] = best[0];
                                testSet[secondPos] = best[1];
                                // System.out.println("Placed params " + best[0]
                                // + " " +
                                // best[1] + " at " + firstPos + " and " +
                                // secondPos);
                                // Console.ReadLine();

                                // for remaining parameter positions in
                                // candidate testSet,
                                // try each possible legal value, picking the
                                // one which
                                // captures the most unused pairs . . .
                                for (int i = 2; i < numberParameters; ++i) // start
                                                                           // at
                                                                           // 2
                                                                           // because
                                                                           // first
                                                                           // two
                                                                           // parameter
                                                                           // have
                                                                           // been
                                                                           // placed
                                {
                                        int currPos = ordering[i];
                                        int[] possibleValues = legalValues[currPos];
                                        // System.out.println("possibles are ");
                                        // for (int z = 0; z <
                                        // possibleValues.length; ++z)
                                        // System.out.println(possibleValues[z]);
                                        // System.out.println("");

                                        int currentCount = 0; // count the
                                                              // unusedPairs
                                                              // grabbed
                                                              // by adding a
                                                              // possible value
                                        int highestCount = 0; // highest of
                                                              // these counts
                                        int bestJ = 0; // index of the possible
                                                       // value which
                                                       // yields the
                                                       // highestCount
                                        for (int j = 0; j < possibleValues.length; ++j) // examine
                                                                                        // pairs
                                                                                        // created
                                                                                        // by
                                                                                        // each
                                                                                        // possible
                                                                                        // value
                                                                                        // and
                                                                                        // each
                                                                                        // parameter
                                                                                        // value
                                                                                        // already
                                                                                        // there
                                        {
                                                currentCount = 0;
                                                for (int p = 0; p < i; ++p) // parameters
                                                                            // already
                                                                            // placed
                                                {
                                                        int[] candidatePair = new int[] {
                                                                        possibleValues[j],
                                                                        testSet[ordering[p]] };
                                                        // System.out.println("Considering pair "
                                                        // +
                                                        // possibleValues[j] +
                                                        // ", " +
                                                        // testSet[ordering[p]]);

                                                        if (unusedPairsSearch[candidatePair[0]][candidatePair[1]] == 1
                                                                        || unusedPairsSearch[candidatePair[1]][candidatePair[0]] == 1) // because
                                                                                                                                       // of
                                                                                                                                       // the
                                                                                                                                       // random
                                                                                                                                       // order
                                                                                                                                       // of
                                                                                                                                       // positions,
                                                                                                                                       // must
                                                                                                                                       // check
                                                                                                                                       // both
                                                                                                                                       // possibilities
                                                        {
                                                                // System.out.println("Found "
                                                                // +
                                                                // candidatePair[0]
                                                                // + "," +
                                                                // candidatePair[1]
                                                                // +
                                                                // " in unusedPairs");
                                                                ++currentCount;
                                                        } else {
                                                                // System.out.println("Did NOT find "
                                                                // +
                                                                // candidatePair[0]
                                                                // + "," +
                                                                // candidatePair[1]
                                                                // +
                                                                // " in unusedPairs");
                                                        }
                                                } // p -- each previously placed
                                                  // paramter
                                                if (currentCount > highestCount) {
                                                        highestCount = currentCount;
                                                        bestJ = j;
                                                }

                                        } // j -- each possible value at currPos
                                          // System.out.println("The best value is "
                                          // +
                                          // possibleValues[bestJ] +
                                          // " with count = " +
                                          // highestCount);

                                        testSet[currPos] = possibleValues[bestJ]; // place
                                                                                  // the
                                                                                  // value
                                                                                  // which
                                                                                  // captured
                                                                                  // the
                                                                                  // most
                                                                                  // pairs
                                } // i -- each testSet position

                                // =========
                                // System.out.println("\n============================");
                                // System.out.println("Adding candidate testSet to candidateSets array: ");
                                // for (int i = 0; i < numberParameters; ++i)
                                // System.out.print(testSet[i] + " ");
                                // System.out.println("");
                                // System.out.println("============================\n");

                                candidateSets[candidate] = testSet; // add
                                                                    // candidate
                                                                    // testSet
                                                                    // to
                                                                    // candidateSets
                                                                    // array
                        } // for each candidate testSet

                        // System.out.println("Candidates testSets are: ");
                        // for (int i = 0; i < candidateSets.length; ++i)
                        // {
                        // int[] curr = candidateSets[i];
                        // System.out.print(i + ": ");
                        // for (int j = 0; j < curr.length; ++j)
                        // {
                        // System.out.print(curr[j] + " ");
                        // }
                        // System.out.println(" -- captures " +
                        // NumberPairsCaptured(curr, unusedPairsSearch));
                        // }

                        // Iterate through candidateSets to determine the best
                        // candidate

                        int indexOfBestCandidate = r
                                        .nextInt(candidateSets.length); // pick
                                                                        // a
                                                                        // random
                                                                        // index
                                                                        // as
                                                                        // best
                        int mostPairsCaptured = NumberPairsCaptured(
                                        candidateSets[indexOfBestCandidate],
                                        unusedPairsSearch);

                        int[] bestTestSet = new int[numberParameters];

                        for (int i = 0; i < candidateSets.length; ++i) {
                                int pairsCaptured = NumberPairsCaptured(
                                                candidateSets[i],
                                                unusedPairsSearch);
                                if (pairsCaptured > mostPairsCaptured) {
                                        mostPairsCaptured = pairsCaptured;
                                        indexOfBestCandidate = i;
                                }
                                // System.out.println("Candidate " + i +
                                // " captured " +
                                // mostPairsCaptured);
                        }
                        // System.out.println("Candidate number " +
                        // indexOfBestCandidate
                        // + " is best");
                        System.arraycopy(
                                        candidateSets[indexOfBestCandidate],
                                        0,
                                        bestTestSet,
                                        0,
                                        candidateSets[indexOfBestCandidate].length);
                        // candidateSets[indexOfBestCandidate].CopyTo(bestTestSet,
                        // 0);
                        testSets.add(bestTestSet); // Add the best candidate to
                                                   // the main
                                                   // testSets List

                        // now perform all updates

                        // System.out.println("Updating unusedPairs");
                        // System.out.println("Updating unusedCounts");
                        // System.out.println("Updating unusedPairsSearch");
                        for (int i = 0; i <= numberParameters - 2; ++i) {
                                for (int j = i + 1; j <= numberParameters - 1; ++j) {
                                        int v1 = bestTestSet[i]; // value 1 of
                                                                 // newly added
                                                                 // pair
                                        int v2 = bestTestSet[j]; // value 2 of
                                                                 // newly added
                                                                 // pair

                                        // System.out.println("Decrementing the unused counts for "
                                        // + v1 + " and " + v2);
                                        --unusedCounts[v1];
                                        --unusedCounts[v2];

                                        // System.out.println("Setting unusedPairsSearch at "
                                        // +
                                        // v1 + " , " + v2 + " to 0");
                                        unusedPairsSearch[v1][v2] = 0;

                                        for (int p = 0; p < unusedPairs.size(); ++p) {
                                                int[] curr = unusedPairs.get(p);

                                                if (curr[0] == v1
                                                                && curr[1] == v2) {
                                                        // System.out.println("Removing "
                                                        // + v1 + ", " +
                                                        // v2 +
                                                        // " from unusedPairs List");
                                                        unusedPairs.remove(p);
                                                }
                                        }
                                } // j
                        } // i

                } // primary while loop

        }

        private List<List<FactorValue>> convertToPatterns() {
                List<List<FactorValue>> patterns = new ArrayList<List<FactorValue>>(
                                testSets.size());
                for (int i = 0; i < testSets.size(); ++i) {
                        List<FactorValue> pattern = new ArrayList<FactorValue>();
                        int[] curr = testSets.get(i);
                        for (int j = 0; j < numberParameters; ++j) {
                                pattern.add(new FactorValue(j,
                                                parameterValues[curr[j]]));
                        }
                        patterns.add(pattern);
                }
                return patterns;
        }

        public List<List<FactorValue>> generate(List<AllPairFactor> factors) {
                try {
                        getParameters(factors);
                        initializePairs();
                        computeTestSets();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return convertToPatterns();
        } // Main()

        public List<List<FactorValue>> generateFromFile() {
                try {
                        getParametersFromFile("src/testData.txt");
                        initializePairs();
                        computeTestSets();
                } catch (Exception e) {
                        e.printStackTrace();
                }

                return convertToPatterns();
        } // Main()

        private int NumberPairsCaptured(int[] ts, int[][] unusedPairsSearch) // number
                                                                             // of
                                                                             // unused
                                                                             // pairs
                                                                             // captured
                                                                             // by
                                                                             // testSet
                                                                             // ts
        {
                int ans = 0;
                for (int i = 0; i <= ts.length - 2; ++i) {
                        for (int j = i + 1; j <= ts.length - 1; ++j) {
                                if (unusedPairsSearch[ts[i]][ts[j]] == 1)
                                        ++ans;
                        }
                }
                return ans;
        } // NumberPairsCaptured()
}
