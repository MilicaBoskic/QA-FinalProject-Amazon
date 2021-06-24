<h2>Java/Selenium</h2>
<br>

<b>TEST CASES</b>

- <i>[Amazon.es] - Adding an item to the cart</i>

1) Navigate to "https://www.amazon.es/"
2) Click on the "Aceptar" button to close pop-up
3) Click on the "Todos los departamentos" drop-down menu
4) Select the option "Salud y cuidado personal"
5) In the search box enter "BAUSCH + LOMB - Biotrue® ONEday - Lentes de contacto de reemplazo diario"
6) Click on the magnifier icon
7) Locate and select "BAUSCH + LOMB - Biotrue® ONEday - Lentes de contacto de reemplazo diario" item
8) Click on the "Dioptría" drop-down menu
9) Select the option "-1.5 Dioptrías"
10) Click on "90" button in order to select units
11) Click on "Enviar a" button
12) In the empty field located below "o introduce un código postal en España" enter "28010"
13) Click on the "Confirmar" button
14) Click on the "Compra única" button
15) Click on the "Añadir a la cesta" button
16) Click on the "Cesta" button

Expected result: Product is successfully added to cart and Cart icon shows 1 item in it. Product price and title in cart match product price and title on product detail page.


- <i>[Amazon.es] - Removing an item from the cart</i>

1) Navigate to "https://www.amazon.es/"
2) Click on the "Aceptar" button to close pop-up
3) Click on the "Todos los departamentos" drop-down menu
4) Select the option "Salud y cuidado personal"
5) In the search box enter "BAUSCH + LOMB - Biotrue® ONEday - Lentes de contacto de reemplazo diario"
6) Click on the magnifier icon
7) Locate and select "BAUSCH + LOMB - Biotrue® ONEday - Lentes de contacto de reemplazo diario" item
8) Click on the "Dioptría" drop-down menu
9) Select the option "-1.5 Dioptrías"
10) Click on "90" button in order to select units
11) Click on "Enviar a" button
12) In the empty field located below "o introduce un código postal en España" enter "28010"
13) Click on the "Confirmar" button
14) Click on the "Compra única" button
15) Click on the "Añadir a la cesta" button
16) Click on the "Cesta" button
17) Click on the "Eliminar" button

Expected result: Product is removed from the cart and Cart icon shows 0 items. The message "Tu cesta de Amazon está vacía" is displayed.

- <i>[Amazon.es] - Search functionality validation</i>

1) Navigate to "https://www.amazon.es/"
2) Click on the "Aceptar" button to close pop-up
3) Click on the "Todos los departamentos" drop-down menu
4) Select the option "Música: CDs y vinilos"
5) In the search box enter "Guitarricadelafuente"
6) Click on the magnifier icon

Expected result: The "Guitarricadelafuente" term appears in the results.
