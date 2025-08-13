# 🧠 Perceptron – Trabalho Prático 3 (RNA)

📄 **Disciplina:** Redes Neurais Artificiais  
🏫 **Instituição:** CEFET-MG – Campus Timóteo   

---

## 📜 Descrição
Implementação em Java de um **Perceptron** para resolver problemas clássicos de portas lógicas (AND, OR, XOR) e um problema de movimentação de robô, como parte do Trabalho Prático 3 da disciplina de Redes Neurais Artificiais.

---

## 📂 Estrutura do Repositório
- `RNA_TrabalhoPratico3.pdf` – Enunciado do trabalho.  
- `src/rnamain/Perceptron.java` – Implementação da rede neural Perceptron.  
- `src/rnamain/RnaMain.java` – Programa principal com seleção da base de treinamento.  

---

## 🗂️ Bases de Treinamento
No arquivo `RnaMain.java`, há quatro opções de bases (basta comentar/descomentar a desejada):

1. **Porta AND**  
2. **Porta OR**  
3. **Porta XOR**  
4. **Movimento de Robô** (3 entradas e 2 saídas)

---

## 🚀 Como Executar
1. **Clonar o repositório:**
```bash
git clone https://github.com/SamuelOliveira-lab/redes-neurais-perceptron
cd redes-neurais-perceptron
```
2. **Compilar:**

```bash
javac src/rnamain/*.java
```
3. **Executar:**
```bash
java -cp src rnamain.RnaMain
```

## ⚙️ Funcionamento
O Perceptron é inicializado com pesos aleatórios entre -0.3 e 0.3.

A função de ativação utilizada é a sigmóide logística.

O treinamento ajusta os pesos com base no erro entre a saída desejada e a saída obtida.

Taxa de aprendizado (ni) = 0.3.

Treinamento de até 10.000 épocas.

📊 Exemplo de Saída (Porta AND)
```python-repl
1 - 1.8234
2 - 1.6521  
.....
9999 - 0.0000
```

📌 Observações
Para testar outra base, altere o array base no início de RnaMain.java.

O número de entradas e saídas do Perceptron deve ser ajustado no construtor:

```java
Perceptron rna = new Perceptron(2, 1); // Ex.: AND, OR, XOR
Perceptron rna = new Perceptron(3, 2); // Ex.: Robô
