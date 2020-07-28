package com.paypay.api;

import com.google.gson.reflect.TypeToken;
import com.paypay.ApiCallback;
import com.paypay.ApiClient;
import com.paypay.ApiException;
import com.paypay.ApiResponse;
import com.paypay.Configuration;
import com.paypay.Pair;
import com.paypay.model.ProductType;
import com.paypay.model.WalletBalance;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class WalletApi {
    private ApiClient apiClient;

    public WalletApi() {
        this(Configuration.getDefaultApiClient());
    }

    public WalletApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    
    /**
     * Build call for checkWalletBalance
     * @param userAuthorizationId  (required)
     * @param amount  (required)
     * @param currency  (required)
     * @param productType  (optional)
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
        
     */
    private com.squareup.okhttp.Call checkWalletBalanceCall(String userAuthorizationId, Integer amount, String currency,
            ProductType productType) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/v2/wallet/check_balance";

        List<Pair> localVarQueryParams = new ArrayList<>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<>();
        if (userAuthorizationId != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("userAuthorizationId", userAuthorizationId));
        if (amount != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("amount", amount));
        if (currency != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("currency", currency));
        if (productType != null)
            localVarQueryParams.addAll(apiClient.parameterToPair("productType", productType));

        Map<String, String> localVarHeaderParams = new HashMap<>();

        Map<String, Object> localVarFormParams = new HashMap<>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "HmacAuth" };
        apiClient.setReadTimeout(15);
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams,
                localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call checkWalletBalanceValidateBeforeCall(String userAuthorizationId, Integer amount, String currency, ProductType productType) throws ApiException {
        
        
        // verify the required parameter 'userAuthorizationId' is set
        if (userAuthorizationId == null) {
            throw new ApiException("Missing the required parameter 'userAuthorizationId' when calling checkWalletBalance(Async)");
        }
        
        // verify the required parameter 'amount' is set
        if (amount == null) {
            throw new ApiException("Missing the required parameter 'amount' when calling checkWalletBalance(Async)");
        }
        
        // verify the required parameter 'currency' is set
        if (currency == null) {
            throw new ApiException("Missing the required parameter 'currency' when calling checkWalletBalance(Async)");
        }
        
        
        return checkWalletBalanceCall(userAuthorizationId, amount, currency, productType);
    }

    /**
     * Check user wallet balance
     * Check if user has enough balance to make a payment  **Timeout: 15s** 
     * @param userAuthorizationId  (required)
     * @param amount  (required)
     * @param currency  (required)
     * @param productType  (optional)
     * @return WalletBalance
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
        
     */
    public WalletBalance checkWalletBalance(String userAuthorizationId, Integer amount, String currency, ProductType productType) throws ApiException {
        ApiResponse<WalletBalance> resp = checkWalletBalanceWithHttpInfo(userAuthorizationId, amount, currency, productType);
        return resp.getData();
    }

    /**
     * Check user wallet balance
     * Check if user has enough balance to make a payment  **Timeout: 15s** 
     * @param userAuthorizationId  (required)
     * @param amount  (required)
     * @param currency  (required)
     * @param productType  (optional)
     * @return ApiResponse&lt;WalletBalance&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
        
     */
    private ApiResponse<WalletBalance> checkWalletBalanceWithHttpInfo(String userAuthorizationId, Integer amount,
            String currency, ProductType productType) throws ApiException {
        com.squareup.okhttp.Call call = checkWalletBalanceValidateBeforeCall(userAuthorizationId, amount, currency, productType);
        Type localVarReturnType = new TypeToken<WalletBalance>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Check user wallet balance (asynchronously)
     * Check if user has enough balance to make a payment  **Timeout: 15s** 
     * @param userAuthorizationId  (required)
     * @param amount  (required)
     * @param currency  (required)
     * @param productType  (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
        
     */
    public com.squareup.okhttp.Call checkWalletBalanceAsync(String userAuthorizationId, Integer amount, String currency, ProductType productType, final ApiCallback<WalletBalance> callback) throws ApiException {
        com.squareup.okhttp.Call call = checkWalletBalanceValidateBeforeCall(userAuthorizationId, amount, currency, productType);
        Type localVarReturnType = new TypeToken<WalletBalance>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    
}