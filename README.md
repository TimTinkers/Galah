# Galah
Galah is a demonstration using Web3j and a Java networking layer to show the Unreal Engine interacting with a smart contract. The project consists of three distinct parts: the Solidity smart contract, the Java networking middle layer, and the Unreal Engine project.

## The Smart Contract
In the "CounterContract" folder, this repository includes all files necessary to setup a [Truffle](https://github.com/trufflesuite/truffle) project to test and deploy a simple "Counter.sol" Solidity smart contract counter which can increment and store a public integer. The example contract as it is deployed live for the demonstrations here can be viewed [here with Etherscan](https://kovan.etherscan.io/address/0xdfd3dc96aadeffea374bde3380ed20c4072f46b7). The Counter was kept intentionally simple for this demonstration, but the interaction between the Unreal Engine and smart contracts is easily extensible to more interesting cases.

In the specified folder's "configuration.js" file one can specify a node URL and 12 word secret phrase, which are both used to deploy the contract from some account. In the examples here I am deploying to a cloud-hosted node on the Kovan test network using [Infura](https://infura.io/). The example contract also includes a "counter.js" test file in its test directory to verify the correct behavior of the example contract.

## The Networking Layer
In the "GalahServer" folder, this repository includes an example server which uses [Web3j](https://web3j.io/) to communicate with the deployed Counter contract and the [LowEntry Socket Connection](https://www.unrealengine.com/marketplace/low-entry-socket-connection) plugin to communicate with the Unreal Engine. Additionally, this server has a dependency on [json-simple](https://github.com/fangyidong/json-simple), a JSON parser which is used to generate the JSON packets sent between the server and the Unreal Engine application. The Java wrapper for the Counter contract was generated using these [Web3j instructions](https://docs.web3j.io/smart_contracts.html#smart-contract-wrappers). The resulting .abi and .bin files are included in "CounterContract/solc_compiled" and required separate installation of the [solc-js](https://github.com/ethereum/solc-js) Solidity compiler bindings.

When starting, this server first reads configuration details from "config/config.txt" where the user must specify the URL of their Ethereum node and the private key of the wallet used to pay for transaction fees incurred when interacting with the smart contract. Once it has successfully connected to the smart contract, the server simply opens a socket and listens for incoming JSON messages. The server responds to messages with two different "action" field values: "increment" and "read." These fields respectively determine whether the server will issue a function call to the Counter contract to increment its count variable, or whether it will read the value of count and return this to the initial sender.

## The Unreal Engine Project

## References
The following resoures proved helpful for developing this project.
- [ConsenSys Smart Contract Intro](https://medium.com/@ConsenSys/a-101-noob-intro-to-programming-smart-contracts-on-ethereum-695d15c1dab4), a useful beginner's guide for developing and deploying smart contracts.
- [Web3j Starting Guide](https://docs.web3j.io/getting_started.html), a detailed tutorial for setting up communication between Java and smart contracts.
- Education resources provided by the University of Pennsylvania Blockchain Club.

## Supporting Code
This project requires and would not have been possible without the following frameworks and libraries:
- [Truffle](https://github.com/trufflesuite/truffle), a development environment, testing framework and asset pipeline for Ethereum.
- [Etherscan](https://kovan.etherscan.io/address/0xdfd3dc96aadeffea374bde3380ed20c4072f46b7), an Ethereum block explorer.
- [Infura](https://infura.io/), a gateway for cloud-hosted Ethereum nodes.
- [Web3j](https://web3j.io/), a lightweight, reactive, type-safe Java and Android library for integrating with nodes on Ethereum blockchains.
- [LowEntry Socket Connection](https://www.unrealengine.com/marketplace/low-entry-socket-connection), a useful networking plugin for the Unreal Engine with native Java integration.
- [json-simple](https://github.com/fangyidong/json-simple), a simple and fast JSON parser.
- [solc-js](https://github.com/ethereum/solc-js), JavaScript Solidity compiler bindings used here to create the Java contract wrapper.
