# Eldar Challenge

## API Request
Let's obtain the transaction fee with the following available card brands:
- visa
- naranja
- amex
```bash
curl --location 'https://eldar-challenge.onrender.com/api/v1/transaction' \
--header 'Content-Type: application/json' \
--data '{
    "cardBrand": "amex",
    "transactionAmount": "1000"
}'
```
