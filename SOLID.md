Task 1
S - UsuarioDao na linha 19 o DAO so salva e busca no banco. As regras ficam no UsuarioService
O - PessoaDao na linha 18 Criei o PessoaDao estendendo o GenericDao assim não precisa mexer no GenericDao
L - UsuarioAdmin na linha 11 o UsuarioAdmin estende Usuario e pode ser usado no lugar dele sem quebrar nada pois todo admin e um usuário
I - UsuarioIDao na linha 15 o findByLogin ficou so no UsuarioIDao e não no GenericIDao porque so usuario tem login
D - UsuarioService  na linha 24 o service recebe o UsuarioIDao e o PessoaIDao pelo construtor, não da new neles, assim quem escolhe e o Main

Task 2

S - UsuarioCadastrar linha 199 o metodo faz tudo junto ele confere senha, monta o usuario, salva, mostra mensagem e fecha a tela. São várias coisas em um lugar so
O - UsuarioAdmin linhas 26 o admin compara o texto que o Usuario devolveu "Bem-vindo, ..." se mudar essa frase na classe pai, o admin quebra sem dar erro
I - em Login e UsuarioCadastrar as telas recebem o UsuarioIController inteiro, mas o Login so usa o findByLogin e o Cadastrar so usa o save


obs: esqueci de explicar as correcoes que fiz no PR, mas corrigi o S e o O vou resumir aqui a correcao

S. como o metodo fazia tudo em um so lugar separei ele em metodos pequenos, agora o botao apenas chamas esses metodos
O. como o admin comparava o texto para saber se tinha dado certo, se tivesse alteracao na frase daria erro, entao separei o metodo autenticar em metodos menores e apenas chamo 1 desses metodos no UsuarioAdmin
