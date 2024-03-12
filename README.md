# Eldar Challenge

## API Request
Obtener el costo de una transacción con las siguientes marcas de tarjeta:
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

---
### Ejercicios PL/SQL (3,4)
- La tabla de empleados tiene un total de 107 registros. ¿Cuántos registros imprime la
siguiente consulta?

La respuesta es *a* (10 registros).

- ¿Qué es cierto acerca de la siguiente función?

La respuesta es *e* ("Habrá un error en tiempo de ejecución") ya que el nombre de la variable que recibe la función es "P_Emp_id" y en el SELECT al momento de utilizarla, la invoca con el nombre de P_Emp_Id (notese la diferencia en la i/I).
Esto provocaría un error.

---
### Notas
En el ejercicio 2 se solicita un endpoint que responda y reciba en formato JSON. Decidí realizarlo con el verbo HTTP POST para que cumpla este requisito. La teória dice que no debería ser así ya que no estoy realizando ninguna persistencia. Este tipo de requerimiento entiendo quedaría mejor si fuese un GET y en lugar de recibir un JSON (que si bien puede, no es la norma), sean parámetros. 

Ejemplo:
```
@GetMapping
public ResponseEntity<Object> getTransactionFee(
        @RequestParam("cardName") Brand brand,
        @RequestParam("transactionAmount") Double transactionAmount) {
    return ResponseEntity.ok(
            transactionService.getTransactionFee(brand, transactionAmount)
    );
}
```
