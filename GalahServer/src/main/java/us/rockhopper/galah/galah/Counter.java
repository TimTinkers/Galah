package us.rockhopper.galah.galah;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>
 * Auto generated code.
 * <p>
 * <strong>Do not modify!</strong>
 * <p>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j
 * command line tools</a>, or the
 * org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen
 * module</a> to update.
 *
 * <p>
 * Generated with web3j version 3.1.1.
 */
public final class Counter extends Contract {
	private static final String BINARY =
			"6060604052341561000f57600080fd5b6000805560bf806100216000396000f30060606040526004361060485763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166306661abd8114604d578063d09de08a14606f575b600080fd5b3415605757600080fd5b605d607f565b60405190815260200160405180910390f35b3415607957600080fd5b605d6085565b60005481565b6000805460010190819055905600a165627a7a72305820c1b580142993111bec1d1a36108366a037b30708cef5cdfab3606f0da80688ef0029";

	private Counter(String contractAddress, Web3j web3j,
			Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
	}

	private Counter(String contractAddress, Web3j web3j,
			TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		super(BINARY, contractAddress, web3j, transactionManager, gasPrice,
				gasLimit);
	}

	public RemoteCall<BigInteger> count() {
		@SuppressWarnings("rawtypes")
		Function function = new Function("count", Arrays.<Type> asList(),
				Arrays.<TypeReference<?>> asList(new TypeReference<Uint256>() {
				}));
		return executeRemoteCallSingleValueReturn(function, BigInteger.class);
	}

	public RemoteCall<TransactionReceipt> increment() {
		@SuppressWarnings("rawtypes")
		Function function = new Function("increment", Arrays.<Type> asList(),
				Collections.<TypeReference<?>> emptyList());
		return executeRemoteCallTransaction(function);
	}

	public static RemoteCall<Counter> deploy(Web3j web3j,
			Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
		return deployRemoteCall(Counter.class, web3j, credentials, gasPrice,
				gasLimit, BINARY, "");
	}

	public static RemoteCall<Counter> deploy(Web3j web3j,
			TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		return deployRemoteCall(Counter.class, web3j, transactionManager,
				gasPrice, gasLimit, BINARY, "");
	}

	public static Counter load(String contractAddress, Web3j web3j,
			Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
		return new Counter(contractAddress, web3j, credentials, gasPrice,
				gasLimit);
	}

	public static Counter load(String contractAddress, Web3j web3j,
			TransactionManager transactionManager, BigInteger gasPrice,
			BigInteger gasLimit) {
		return new Counter(contractAddress, web3j, transactionManager, gasPrice,
				gasLimit);
	}
}
