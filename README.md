# ClasesEquivalencia

## Casos de Equivalencia

Para la funcionalidad de registro de votantes, se han definido los siguientes casos de equivalencia:

1. **Edad Menor de 18 Años**
   - **Descripción:** Persona menor de 18 años.
   - **Resultado Esperado:** `UNDERAGE`

2. **Edad Mayor de 120 Años**
   - **Descripción:** Persona con una edad mayor a 120 años.
   - **Resultado Esperado:** `INVALID_AGE`

3. **Persona Muerta**
   - **Descripción:** Persona que está marcada como no viva (`alive = false`).
   - **Resultado Esperado:** `DEAD`

4. **Registro Duplicado**
   - **Descripción:** Persona con un número de identificación que ya ha sido registrado.
   - **Resultado Esperado:** `DUPLICATED`

5. **Persona Válida**
   - **Descripción:** Persona con edad entre 18 y 120 años, viva y con un número de identificación no registrado previamente.
   - **Resultado Esperado:** `VALID`
