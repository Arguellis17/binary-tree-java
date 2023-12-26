# 🌳 ¿Qué son los árboles binarios? 🌳  
<p> Los árboles son estructuras no lineales, al contrario que los arrays y las listas enlazadas, que 
constituyen estructuras lineales.
Casi todos los sistemas operativos almacenan sus archivos en árboles o estructuras similares a 
árboles. Además de las aplicaciones citadas, los árboles se utilizan en diseño de compiladores, 
procesado de texto y algoritmos de búsqueda, además, para organizar objetos en orden de tal 
forma que las búsquedas sean muy eficientes</p>

## 📚 Generalidades 📚
<p> Un árbol consta de un conjunto finito de elementos, denominados nodos y de un conjunto finito de 
líneas dirigidas, denominadas ramas, que conectan los nodos. El número de ramas asociado con un 
nodo es el grado del nodo.  
Si un árbol no está vacío, entonces el primer nodo se llama raíz. En la Figura, el nodo 15 es el raíz. 
Utilizando el concepto de árboles genealógicos, un nodo puede ser considerado como padre si tiene 
nodos sucesores. </p>

<p align="center">
  <a href="https://postimg.cc/0MxhbDMw">
    <img src="https://i.postimg.cc/Kzgbp5mJ/Captura-de-pantalla-2023-12-25-183205.png" alt="Captura de pantalla">
  </a>
</p>

<h3 align="center"> 🍃 ¿Qué es una hoja? 🍃 </h3>

<p> El nodo A es el raíz. El nodo B es el padre de los hijos E y F. El padre de H es el nodo D. Un árbol 
puede representar diversas generaciones en la familia. Los hijos de un nodo y los hijos de estos hijos 
se llaman descendientes, y el padre y los abuelos de un nodo son sus ascendientes. Por ejemplo, los 
nodos E, F, I y J son descendientes de B. <b>Cada nodo no raíz tiene un único padre y cada padre 
tiene cero o más nodos hijos. </b> Dos o más nodos con el mismo padre se llaman hermanos. <b>Un nodo 
sin hijos, tal como E, I, J, G y H se llama nodo hoja. </p> </b>  

<p align="center">
  <a href="https://postimg.cc/YjFmpFN3">
    <img src="https://i.postimg.cc/SQTLf7Jw/2.png" alt="Imagen 2">
  </a>
</p>

<h3 align="center">🏔️ Altura del árbol 🏔️ </h3>

<p> El nivel de un nodo es su distancia al nodo raíz. La raíz tiene una distancia cero de sí misma, por ello 
se dice que está en el nivel 0. Los hijos del nodo raíz están en el nivel 1, sus hijos están en el nivel 2, 
y así sucesivamente. Una cosa importante que se aprecia entre los niveles de nodos es la relación 
entre niveles y hermanos. Los hermanos están siempre al mismo nivel, pero no todos los nodos de 
un mismo nivel son necesariamente hermanos. Por ejemplo, en el nivel 2, C y D son hermanos, al 
igual que lo son G, H, e I, pero D y G no son hermanos, ya que ellos tienen diferentes padres</p>

<p align="center">
<a href="https://postimg.cc/NLMvmhfC"> 
<img src="https://i.postimg.cc/L4k4d2dS/3.png" alt="Altura arbol">
</a>
</p>

## 🛤️ Recorrido de un árbol 🛤️  

<p> El recorrido de un árbol supone visitar cada nodo sólo una vez. Dado un árbol binario que consta de 
raíz, un subárbol izquierdo y un subárbol derecho, se pueden definir tres tipos de secuencia de 
recorrido en profundidad </p>

<p align="center">
<a href="https://postimg.cc/LJBmvtdx">
<img src="https://i.postimg.cc/QdvV8mfZ/4.png" alt="Recorridos del arbol">
</a>
</p>

# 📦 Contenido del repositorio 📦

<table>
  <tr>
    <th>Linked List</th>
    <th>Recursión</th>
    <th>Algunos métodos que encontrás</th>
  </tr>
  <tr>
    <td> Para la construcción y manipulación de árboles, las linked list nos ofrece una estructura dinámica y flexible. Estas linked list provienen de anteriores repostorios, da click  <a href="https://github.com/Arguellis17/edd-linked-list-java">aqui</a> para ir a verlo :). </td>
    <td> Se trabajo con recursión, siendo esta una técnica en programación donde una función se llama a sí misma para resolver un problema. En el contexto de los árboles, la recursión es poderosa porque permite abordar de manera natural y elegante la exploración de cada nivel del árbol.</td>
  <td> Obtener ramas, impresiones del árbol, eliminar un nodo determinado, determinar la altura del árbol, obtener la raíz del árbol, etc.
</td>
  </tr>
</table>
 

