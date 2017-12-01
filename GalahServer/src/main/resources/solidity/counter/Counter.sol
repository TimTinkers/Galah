pragma solidity 0.4.18;


/**
 * This example specifies a simple counter contract which can be incremented
 * through calling the increment() function and tracks a public count value.
 * 
 * @title Counter
 * @author Tim Clancy
 */
contract Counter {

    // Public field variable to track the cumulative count.
    uint public count;

    /**
     * A public constructor to initialize the Counter to zero.
     */
    function Counter() public {
        count = 0;
    }

    /**
     * A function which increments the counter and returns the updated value.
     *
     * @return a uint representing the next, incremented value of count.
     */
    function increment() public returns (uint) { 
        count = count + 1;
        return count;
    }
}