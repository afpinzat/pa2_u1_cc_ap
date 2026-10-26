## Preguntas teóricas del ejercicio

### 1. ¿En qué parte del ejercicio se aplica IoC y en cuál DI?

**IoC (Inversión de Control):** en todo el proyecto. El contenedor **ArC** de Quarkus es quien crea y administra las instancias de `VentaService`, `Auditoria`, `DescuentoRegular` y `DescuentoVIP`. Ninguna de estas clases se instancia con `new`; el control de su creación pasa del programador al contenedor.

**DI (Inyección de Dependencias):** en `VentaService`, que recibe sus dependencias de dos formas para demostrar ambas técnicas:

- **Por constructor:** `CalculadoraDescuento` (con `@Named("REGULAR")` y `@Named("VIP")`).
- **Por atributo:** `Auditoria` con `@Inject` sobre el campo.

---

### 2. ¿Qué función cumplen los Qualifiers y por qué son necesarios?

Los **Qualifiers** (`@Named("REGULAR")`, `@Named("VIP")`) permiten distinguir entre varias implementaciones de una misma interfaz (`CalculadoraDescuento`).

Sin ellos, al haber dos beans del mismo tipo, ArC no sabría cuál inyectar en cada punto y lanzaría `AmbiguousResolutionException` al arrancar.

Con ellos, se indica explícitamente qué implementación va en cada inyección: `REGULAR` para ventas regulares y `VIP` para ventas VIP.

---

### 3. ¿Cuál es la diferencia entre `@ApplicationScoped` y `@Dependent`?

@ApplicationScoped: el contenedor crea una sola instancia por aplicación y la reutiliza en todos los puntos de inyección. Vive mientras viva la aplicación.

@Dependent: el contenedor crea una instancia nueva cada vez que se inyecta. Su ciclo de vida depende del componente gestionado que la inyecta (si el componente gestionado desaparece, la instancia @Dependent también).

---

### 4. ¿Por qué las instancias `@ApplicationScoped` pueden reutilizarse entre varias ventas?

Porque el contenedor ArC crea **una única instancia** y la mantiene viva durante toda la aplicación.

Como `VentaService` no guarda estado por venta (solo un contador global y referencias inmutables a las calculadoras y auditoría), es seguro reutilizar la misma instancia en todas las ventas.

Esto se evidencia con el **UUID**: al imprimir el identificador de `VentaService` antes y después de procesar las ventas, el UUID es el mismo, confirmando que no se creó una instancia nueva.

---

### 5. ¿Qué sucedería si se elimina el Qualifier de un punto de inyección de `CalculadoraDescuento`?

Al existir dos implementaciones (`DescuentoRegular` y `DescuentoVIP`) del mismo tipo `CalculadoraDescuento`, ArC no podría resolver cuál inyectar y fallaría al arrancar con `AmbiguousResolutionException`.

Se necesitaría marcar una de ellas con `@Default` o mantener el `@Named` en el punto de inyección. Por eso los **Qualifiers son obligatorios** en este escenario.
