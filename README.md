Module 3 - Maintainability & OO Principles <br>
1. SRP (Single Responsibily Principle) adalah prinsip yang menyebutkan bahwa sebuah class harus melakukan satu hal saja. Contoh penerapannya dalam tutorial ini adalah saya memisahkan ProductController dengan CarController karena kedua class tersebut melakukan tugas yang berbeda. CarController juga tidak menggunakan method pada ProductController sehingga extension ProductController dihapus.
2. OCP (Open-Closed Principle) adalah prinsip yang menyebutkan bahwa suatu modul harus bisa ditambah fiturnya (di-extends) tanpa harus memodifikasi code yang sudah ada. Contoh penerapannya dalam tutorial ini adalah untuk menambahkan class Car pada project, saya hanya perlu untuk membuat class-class baru tanpa memodifikasi file yang sudah pernah dibuat.
3. LSP (Liskov Substitution Principle) adalah prinsip yang menyebutkan bahwa subclass harus memiliki perilaku yang sesuai dengan superclassnya. Contoh penerapan dalam tutorial ini adalah ProductServiceImpl dan CarServiceImpl melakukan tugasnya sesuai yang diharapkan dari interfacenya masing-masing.
4. ISP (Interface Segregation Principle) adalah prinsip yang menyebutkan untuk tidak mengharuskan penggunaan interface yang tidak dipakai. Dalam tutorial ini, interface CarService dan ProductService sama-sama berperan sesuai fungsinya dan tidak ada yang "menganggur".
5. DIP (Dependency Inversion Principle) adalah prinsip yang menyebutkan bahwa sebuah modul high-level harus bergantung kepada abstarksi, bukan implementasinya. Contoh penerapan dalam tutorial ini adalah pada CarController.java dengan mengganti reference CarServiceImpl menjadi CarService yang merupakan abstract class nya.

Kelebihan menerapkan SOLID
1. Dengan SRP, kode lebih mudah dipahami karena satu class hanya menangani satu tugas
2. Dengan OCP, kode lebih mudah untuk ditambah fiturnya
3. Dengan LSP, dapat meningkatkan code reusability karena subclass bekerja sesuai dengan harapan superclassnya
4. Dengan ISP, dapat mempersingkat kode dengan membuat interface yang lebih spesifik
5. Dengan DIP, dapat meningkatkan decoupling yang membuat project lebih mudah ditambah fiturnya atau di-refactor.

Kekurangan tidak Menerapkan SOLID
1. Kode lebih sulit dipahami
2. Kode harus dimodifikasi jika ingin menambahkan fitur, akan menambah kompleksitas project.
3. Sulit untuk menemukan bug pada project

Module 2 - CI/CD & DevOps <br>
Link deployment https://tutorial-1-adpro-kimiagastya.koyeb.app/

1. Code quality issue yang muncul pada PMD adalah penggunaan access modifier public pada semua method di interface ProductService. Secara implisit, method pada interface sudah memiliki access modifier public sehingga memberikan public pada method dapat dibilang redundan. Memperbaiki issue tersebut mudah, hanya perlu menghapus setiap modifier public pada setiap method.
2. Ya, implementasi CI/CD workflows saat ini memenuhi definisi Continuous Integration and Continuous Deployment. Setiap commit dan push, dijalankan code scanning dengan OSSF Scorecard dan PMD. Instruksi tersebut dapat dikonfigurasi pada file ci.yml. Hal tersebut sejalan dengan konsep Continuous Integration. Selain itu, dijalankan juga proses deploy untuk versi web terbaru pada Koyeb yang sejalan dengan konsep Continuous Deployment.

Module 1 - Coding Standards

Reflection 1
Pertama, saya sudah melakukan penamaan variabel yang jelas, sesuai dengan data yang disimpan sehingga tidak memerlukan komentar untuk menjelaskan variabelnya.
Kedua, saya bisa melihat dari aspek penulisan komentar. Sebelum saya mengikuti perkuliahan Pemrograman Lanjut, terkadang saya masih menuliskan komentar terhadap alur program yang sebenarnya sudah jelas dari penamaan variabel serta alurnya, atau menuliskan kode yang terlalu panjang yang seharusnya bisa di-refactor menjadi beberapa variabel dengan penamaan variabel yang jelas. Kebiasaan tersebut sudah saya coba tinggalkan dan di sini saya menerapkan aturan penulisan kode yang sesuai dengan prinsip clean code. Saya tidak menuliskan komentar sama sekali di kode saya karena saya merasa penamaan variabel serta alur program sudah jelas sehingga tidak memerlukan komentar.
Ketiga, atribut dalam class saya buat visibilitasnya private agar class lain tidak bergantung dengan atribut tersebut.
Untuk peningkatan ke depan, saya dapat memulai untuk tidak lagi melakukan return null dalam sebuah function.

Reflection 2
1. Setelah membuat unit test, saya merasa kode saya lebih terjamin kebenarannya dan bekerja sesuai dengan keinginan saya. Menurut saya, sebanyak apapun unit test yang dibuat tidak cukup untuk memverifikasi program yang kita buat. Dalam aplikasi skala besar, testing tidak akan pernah berhenti. Ketika user menggunakan aplikasi kita, maka user tersebut sedang melakukan tes terhadap aplikasi kita.
2. Keputusan untuk membuat class baru dengan prosedur yang sama dapat dinilai kurang tepat. Hal tersebut tidak sesuai prinsip DRY dalam pemrograman yang merupakan akronim dari Don't Repeat Yourself yang berarti tidak boleh melakukan prosedur yang sama secara berulang. Test suite dapat ditingkatkan dengan membuat sebuah fungsi setup yang terpisah dengan fungsi tesnya. Dengan demikian, dapat terpenuhi aturan yang menyatakan bahwa satu fungsi menjalankan tepat satu hal.
