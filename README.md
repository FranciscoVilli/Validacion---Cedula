Validación de Cédulas Ecuatorianas 🇪🇨
Este proyecto implementa un validador de cédulas ecuatorianas en Java, siguiendo las reglas oficiales establecidas por el Registro Civil del Ecuador. Además, incluye una batería de 500 pruebas automáticas con números aleatorios para verificar la robustez del algoritmo.

🧠 ¿Cómo funciona?
La cédula ecuatoriana tiene 10 dígitos y su validación se basa en:

Reglas regionales: Los dos primeros dígitos indican la provincia (01-24).

Dígito verificador: El décimo dígito se calcula mediante un algoritmo de módulo 10.

Coeficientes alternos: Los dígitos en posiciones impares se multiplican por 2, los pares se mantienen igual (con ajustes si hay resultados mayores a 9).

🧪 Pruebas
Se realizaron 500 pruebas automáticas generando cédulas aleatorias válidas e inválidas para:

Confirmar que el algoritmo no valide cédulas incorrectas.

Asegurar que cédulas con formato válido pasen la validación correctamente.

Evaluar el rendimiento del validador frente a múltiples entradas.

📌 Requisitos
Java 8 o superior

IDE recomendado: IntelliJ IDEA o VS Code

👨‍💻 Autor
Francisco Villalba
Estudiante de Ingeniería en Software, EPN 🇪🇨
GitHub | LinkedIn

