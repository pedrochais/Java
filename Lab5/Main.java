import pessoa.*;
import sistema.*;

public class Main {
    public static void main(String args[]){
        Sistema sistema = new Sistema();
        Menu menu = new Menu();
        int menu_1, menu_2, menu_3;

        menu_1 = -1;
        while(menu_1 != 0){
            menu_1 = menu.principal(); 
            switch(menu_1){ // 1° nível

                case 1: // 1
                    menu_2 = -1;
                    while(menu_2 != 0){ // 2° nível
                        menu_2 = menu.cadastro(); // 1
                        switch(menu_2){

                            case 1: // 1.1
                                menu_3 = -1;
                                while(menu_3 != 0){ // 3° nível
                                    menu_3 = menu.cadastroPessoa(); // 1.1
                                    switch(menu_3){
                                        
                                        case 1: // 1.1.1
                                            menu.cadastroAluno(sistema);  // 1.1.1
                                        break;

                                        case 2: // 1.1.2
                                            menu.cadastroDocente(sistema);// 1.1.2
                                        break;
                                    }
                                    
                                }
                            break;
                            
                            case 2: // 1.2
                                menu_3 = -1; 
                                while(menu_3 != 0){ // 3° nível
                                    menu_3 = menu.cadastroEntidade(); // 1.2
                                    switch(menu_3){

                                        case 1: // 1.2.1
                                            menu.cadastroCurso(sistema);   // 1.2.1
                                        break;
                                        case 2: // 1.2.2
                                            menu.cadastroDisciplina(sistema);   // 1.2.2
                                        break;
                                        case 3: // 1.2.3
                                            menu.cadastroTurma(sistema);        // 1.2.3
                                        break;
                                    }
                                }
                            break;

                            case 3: // 1.3
                                menu_3 = -1;
                                while(menu_3 != 0){ // 3° nível
                                    menu_3 = menu.cadastroAtividade(); // 1.3
                                    switch(menu_3){

                                        case 1: // 1.3.1
                                            menu.cadastroExercicio(sistema);   // 1.3.1
                                        break;
                                        case 2: // 1.3.2
                                            menu.cadastroProva(sistema);   // 1.3.2
                                        break;
                                    }
                                }
                            break;
                        }
                    }
                break;
                
                case 2: // 2
                    menu_2 = -1;
                    while(menu_2 != 0){ // 2° nível
                        menu_2 = menu.consultar();
                        switch(menu_2){

                            case 1: // 2.1
                                menu_3 = -1;
                                while(menu_3 != 0){ // 3° nível
                                    menu_3 = menu.consultarPessoa();
                                    switch(menu_3){
                                        case 1: // 2.1.1
                                            menu.consultarAluno(sistema);
                                        break;
                                        case 2: // 2.1.2
                                            menu.consultarDocente(sistema);
                                        break;
                                    }
                                }
                            break;

                            case 2: // 2.2
                                menu_3 = -1;
                                while(menu_3 != 0){ // 3° nível
                                    menu_3 = menu.consultarEntidade();
                                    switch(menu_3){
                                        case 1: // 2.2.1
                                            menu.consultarCurso(sistema);
                                        break;
                                        case 2: // 2.2.2
                                            menu.consultarDisciplina(sistema);
                                        break;
                                        case 3: // 2.2.3
                                            menu.consultarTurma(sistema);
                                        break;
                                    }
                                }
                            break;

                            case 3: // 2.3
                                menu_3 = -1;
                                while(menu_3 != 0){ // 3° nível
                                    menu_3 = menu.consultarAtividade();
                                    switch(menu_3){
                                        case 1: // 2.3.1
                                            menu.consultarExercicio(sistema);
                                        break;
                                        case 2: // 2.3.2
                                            menu.consultarProva(sistema);
                                        break;
                                    }
                                }
                            break;
                                
                        }
                    }
                break;

                case 3: // 3
                    menu_2 = -1;
                    while(menu_2 != 0){ // 2° nível
                        menu_2 = menu.gerenciar();
                        switch(menu_2){

                            case 1: // 3.1
                                menu_3 = -1;
                                while(menu_3 != 0){ // 3° nível
                                    int turma = menu.selecionarTurma(sistema);
                                    if(turma == 0) break;
                                    while(true){
                                        menu_3 = menu.gerenciarTurmas(sistema, turma-1);
                                        if(menu_3 == 0){
                                            menu_3 = -1;
                                            break;
                                        }          
                                        switch(menu_3){

                                            case 1: // 3.1.1
                                                menu.matricularAlunos(sistema, turma-1);
                                            break;

                                            case 2: // 3.1.2
                                                menu.atribuirExercicios(sistema, turma-1);
                                            break;

                                            case 3: // 3.1.3
                                                menu.atribuirProva(sistema, turma-1);
                                            break;

                                            case 4: // 3.1.4
                                                menu.atribuirNotas(sistema, turma-1);
                                            break;

                                            case 5: // 3.1.5
                                                menu.atribuirFrequencia(sistema, turma-1);
                                            break;
                                        }
                                    }
                                }
                            break;
                        }
                    }
                break;

                case 4: // 4
                    menu_2 = -1;
                    while(menu_2 != 0){ // 2° nível
                        menu_2 = menu.relatorios();
                        switch(menu_2){
                            case 1: // 4.1
                                menu_3 = -1;
                                while(menu_3 != 0){ // 3° nível
                                    int turma = menu.selecionarTurma(sistema);
                                    if(turma == 0) break;
                                    while(true){
                                        menu_3 = menu.relatoriosTurma(sistema, turma-1);
                                        if(menu_3 == 0){
                                            menu_3 = -1;
                                            break;
                                        }          
                                        switch(menu_3){
                                            case 1: // 4.1.1
                                                menu.relatorioFrequencia(sistema, turma-1);
                                            break;

                                            case 2: // 4.1.2
                                                menu.relatorioNotas(sistema, turma-1);
                                            break;
                                        }
                                    }
                                }
                            break;
                        }
                    }
                break;
                
            }
        }    
    }
}
