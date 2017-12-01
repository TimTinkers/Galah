/*
 * A file to specify tests for the truffle testing process.
 * 
 * @author Tim Clancy
 * @version 1.0.0
 * @date 12.1.2017
 */

// Load the counter contract and test to make sure it works as expected.
const Counter = artifacts.require("Counter");

// Define the test cases to run.
contract('Counter', function (accounts) {

	// Test initialization to make sure the Counter starts at zero.
	it("Initial count should be zero.", 
	function () {
		Counter.new().then(function (ctr) {
			return ctr.count.call();
		}).then(function (result) {
			assert.strictEqual(result.toNumber(), 0);
		}).catch((err) => { throw new Error(err); })
	}),

	// Test incrementing the Counter to make sure it updates properly.
	it("Incrementing should update count and return new value.",
	function () {
		var ctr;
		Counter.new().then(
		function (result) {
			ctr = result;
			return ctr.count.call();
		}).then(
		function (result) {
			assert.strictEqual(result.toNumber(), 0);
		}).then(
		function () {
			out = ctr.increment.call();
			ctr.increment();
			return out
		}).then(function (result) {
			assert.strictEqual(result.toNumber(), 1);
		}).then(
		function () {
			return ctr.count.call();
		}).then(
		function (result) {
			assert.strictEqual(result.toNumber(), 1);
		}).then(
		function () {
			out = ctr.increment.call();
			ctr.increment();
			return out;
		}).then(
		function (result) {
			assert.strictEqual(result.toNumber(), 2);
		}).catch((err) => { throw new Error(err); })
	})
});