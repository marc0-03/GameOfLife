# Game Of Life 🤨
Marcus Nylund - 2021-12-06

## Inledning
Syftet med projektet var att koda en egen verision av John Conway's game of life.
Jag skulle jobba enligt MVC modellen och valde att skapa en klass för celler och att ha dem i en 2d arraylist. Jag valde att uppdatera mina celler i min model och visa dom med hjälp av Canvas. 

## Bakgrund
### Cell Klass
En Cell har ett endra värde, en Boolean som säger om den är vid liver eller är död. En Cell har 3 funktioner, en getter en setter och en funktion som flipar den från död till levande
### Modelen 
Modelens storlek får den från controllern och skapar celler 50/50 döda eller levande i alla positioner i 2D arraylisten. I modelen updateras spelet, detta betyder att alla celernas granar kollas i modelen och alla celer uppdateras beroende på deras granar i modeln
### Controller
Contollern skapar Modelen och ger världen storlek samt skapar den view med fönstrets storlek. Controller updaterar sen modelen och visar det på view.
I controllern finns också Keybinds som "uppdaterar spelet" enligt anorlunda regler och en mouselistener för att kunna göra döda celler levande och levande celler döda.
### View
View Vissar alla levande celler i modelen och får hur stor varenda cell ska vara engligt formeln nedan.
 CellWidth = (getWidth() / Cells.length);
 CellHeight = (getHeight() / Cells[0].length);

## Positiva erfarenheter
Har Lärt mig använda 2D arraylists, jag lärde mig scala sakers storlek beroende på skärmens storlek och hur man använder en MouseListener.
 
## Negativa erfarenheter
Jag försökte att använda mouselistner för att lägga till en funktion för att kunna **Dra** min mus för att rita men problemet var att jag borde använt en mouseMotionListener istället.
 Hade riktigt inga andra problem under projektet

## Sammanfattning
en 2D arraylist kan vara en väldigt bra lösning i vissa project och jag vet nu hur jag ska kolla på en viss punkts granar i en 2D arraylist på en ganska effektivt sätt.
