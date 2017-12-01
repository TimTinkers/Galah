/*
 * A file to set deployment options for the truffle deployment process.
 * 
 * @author Tim Clancy
 * @version 1.0.0
 * @date 12.1.2017
 */

// Imports.
var HDWalletProvider = require("truffle-hdwallet-provider");
var configuration = require("./configuration");

// Networks for deploying to.
module.exports = {
	networks: {
		
		// The local network for testing.
		development: {
			host: "localhost",
			port: 8545,
			network_id: "*",
			gas: 4600000
		},
		
		// The Kovan live test network, this requires secrets specified in
		// configuration.js.
		kovan: {
			provider: function() {
				return new HDWalletProvider(configuration.mnemonic, 
					configuration.nodeURL);
			},
			network_id: 42,
			gas: 4600000
		}
	}
};