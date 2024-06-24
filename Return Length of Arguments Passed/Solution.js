/**
 * @param {...(null|boolean|number|string|Array|Object)} args
 * @return {number}
 */



/**
 * 
 * Approach: Straight forward question which is to return the length property of the args variable
 * 
 * Time complexity: O(1) --> Only one operation is executed regardless of input size.
 * 
 * Space complexity: O(1) --> Done in place.
 * 
 * @param  {...any} args 
 * @returns 
 */
var argumentsLength = function(...args) {
    return args.length;
};

/**
 * argumentsLength(1, 2, 3); // 3
 */