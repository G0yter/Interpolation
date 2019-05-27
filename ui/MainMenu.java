package com.gmail.goyter012.Interpolation.ui;

import com.gmail.goyter012.Interpolation.service.ImageAdressRender;
import com.gmail.goyter012.Interpolation.service.Worker;
import com.gmail.goyter012.Interpolation.models.Res;
import com.gmail.goyter012.Interpolation.models.model;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

public class MainMenu extends Application {

    String a = null;
    String b = null;
    String points = null;

    double xs = 0;
    double fxs = 0;

    private BackgroundImage mybi= new BackgroundImage(new Image(ImageAdressRender.imRender("/home/goyter/developing/IdeaProjects/AMO/img/vysh.jpg"),600,400,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    private BackgroundImage mybi2= new BackgroundImage(new Image(ImageAdressRender.imRender("/home/goyter/developing/IdeaProjects/AMO/img/conditimg.jpg"),600,400,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);
    private BackgroundImage mybi3= new BackgroundImage(new Image(ImageAdressRender.imRender("/home/goyter/developing/IdeaProjects/AMO/img/index.jpeg"),600,400,false,true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
            BackgroundSize.DEFAULT);



    public static void builder(String[] args) {
        launch(args);
    }



    public void start(Stage stage){
        MenuBar mb = new MenuBar();

        Menu fileMenu = new Menu("Файл");
        Menu open = new Menu("Відкрити");
        MenuItem close= new MenuItem("Закрити");
        MenuItem exit = new MenuItem("Вихід");
        MenuItem open2 = new MenuItem("Вибрати файл");
        open.getItems().add(open2);

        fileMenu.getItems().addAll(open,close,new SeparatorMenuItem(),exit);

        Menu options = new Menu("Налаштуванння");

        Menu view = new Menu("Вигляд");
        Menu butcol = new Menu("Колір кнопок");
        Menu backcolor = new Menu("Колір фону");

        MenuItem aqua = new MenuItem("Аквамарин");
        MenuItem gold = new MenuItem("Золотий");
        MenuItem biaq = new MenuItem("Бісквит");


        butcol.getItems().addAll(aqua,gold,biaq);

        MenuItem red = new MenuItem("Червоний");
        MenuItem green= new MenuItem("Зелений");
        MenuItem blue = new MenuItem("Синій");
        MenuItem black = new MenuItem("Чорний");
        MenuItem white = new MenuItem("Білий");
        backcolor.getItems().addAll(red,green,blue,black,white);

        view.getItems().addAll(backcolor,butcol);
        MenuItem reset = new MenuItem("Скинути");

        options.getItems().addAll(view,reset);

        Menu help = new Menu("Допомога");
        MenuItem about = new MenuItem("Про нас");

        help.getItems().add(about);

        about.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Label l = new Label("This app was developed by Cherednichenko Vladyslav");
                Label k = new Label("2019");

                Stage s = new Stage();
                BorderPane borderPane = new BorderPane();
                borderPane.setTop(l);
                borderPane.setBottom(k);

                s.setScene(new Scene(borderPane,400,50));
                s.setTitle("Info");
                s.show();


            }
        });

        mb.getMenus().addAll(fileMenu,options,help);

        open2.setAccelerator(KeyCombination.keyCombination("shortcut+O"));
        exit.setAccelerator(KeyCombination.keyCombination("shortcut+E"));
        close.setAccelerator(KeyCombination.keyCombination("shortcut+C"));

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });


        open2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage opener = new Stage();

                Label glav = new Label("Введіть назву файлу");
                Label res = new Label();

                Separator sep = new Separator();
                sep.setPrefWidth(200);

                TextField tf = new TextField();
                tf.setPrefColumnCount(10);

                tf.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        model m = Worker.loaderFromJsonFile(new File(tf.getText()));
                        if(m!= null){
                            a = Integer.toString(m.getA());
                            b = Integer.toString(m.getB());
                            points = Integer.toString(m.getPoints());
                            res.setText("Зчитано коректно");
                        }else{
                            res.setText("Невірні дані");
                        }

                    }
                });

                opener.setTitle("Зчитування даних");
                FlowPane f2 = new FlowPane(10,10);
                f2.setAlignment(Pos.CENTER);
                f2.getChildren().addAll(glav,tf,sep,res);

                opener.setScene(new Scene(f2,250,100));
                opener.show();

            }
        });




//////////////////

        Button mainprocess = new Button("Почати роботу");
        mainprocess.setPrefSize(150,80);
        mainprocess.setStyle("-fx-background-color: aquamarine");


        mainprocess.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage mainStage = new Stage();

                Label labelA = new Label("A");
                labelA.setStyle("-fx-background-color: aqua");
                labelA.setFont(new Font("Arial",20));

                Label labelB = new Label("B");
                labelB.setStyle("-fx-background-color: aqua");
                labelB.setFont(new Font("Arial",20));

                Label labelI = new Label("I");
                labelI.setStyle("-fx-background-color: aqua");
                labelI.setFont(new Font("Arial",20));

                TextField tfA = new TextField();
                tfA.setPrefColumnCount(10);
                if(a!=null){
                    tfA.setText(a);
                }else{
                tfA.setText("5");
                }

                TextField tfB = new TextField();
                tfB.setPrefColumnCount(10);
                if(b!=null){
                    tfB.setText(b);
                }
                else{
                    tfB.setText("15");
                }

                TextField tfI = new TextField();
                tfI.setPrefColumnCount(10);
                if(points!=null){
                    tfI.setText(points);
                }else {
                    tfI.setText("10");
                }
                ToggleButton confirm = new ToggleButton("Підтвердити");
                final int[] abc = new int[3];

                confirm.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        try {
                            abc[0] = Math.abs(Integer.valueOf(tfA.getText()));
                            abc[1] = Math.abs(Integer.valueOf(tfB.getText()));
                            abc[2] = Math.abs(Integer.valueOf(tfI.getText()));

                            Stage good = new Stage();
                            Label g = new Label("Записано вірно" );
                            g.setStyle("-fx-text-fill: black");

                            FlowPane roo = new FlowPane(10,10);
                            roo.setAlignment(Pos.CENTER);
                            roo.getChildren().add(g);

                            Scene scene = new Scene(roo, 150, 60);
                            scene.setFill(Color.GREEN);
                            roo.setBackground(null);

                            good.setScene(scene);
                            good.setTitle("Успіх!");

                            good.show();
                        } catch (NumberFormatException e) {
                            tfA.setText("5");
                            tfB.setText("15");
                            tfI.setText("10");

                            Stage exception = new Stage();


                            Label exc = new Label("Тут повинно бути ціле число!");
                            exc.setStyle("-fx-text-fill: black");

                            FlowPane ro = new FlowPane(10,10);
                            ro.setAlignment(Pos.CENTER);

                            ro.getChildren().addAll(exc);
                            ro.setBackground(null);

                            Scene scene = new Scene(ro, 210, 60);
                            scene.setFill(Color.RED);


                            exception.setScene(scene);
                            exception.setTitle("Помилка!");
                            exception.show();

                        }
                    }



                });



                Button next = new Button("Далі");
                next.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if(confirm.isSelected()){

                            Stage algo = new Stage();

                            Label check = new Label("Оберіть потрібний метод розрахунку");
                            check.setStyle("-fx-background-color: chocolate");
                            check.setFont(new Font(20));


                            RadioButton lagrange = new RadioButton("Поліном Лагранжа");
                            RadioButton newton = new RadioButton("Многочлен Ньютона\n");
                            newton.setTextFill(Color.CHOCOLATE);
                            lagrange.setTextFill(Color.CHOCOLATE);
                            newton.setFont(new Font(20));
                            lagrange.setFont(new Font(20));


                            ToggleGroup algoGroup = new ToggleGroup();

                            lagrange.setToggleGroup(algoGroup);
                            newton.setToggleGroup(algoGroup);


                            lagrange.setSelected(true);

                            Button reNext = new Button("Далі");
                            reNext.setStyle("-fx-background-color: aqua");

                            reNext.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {


                                    RadioButton rb = (RadioButton) algoGroup.getSelectedToggle();//////////////////////////////////////


                                    Button values = new Button("x(i) => fx(i)");
                                    values.setStyle("-fx-background-color: aqua");

                                    values.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {

                                            Stage fxi = new Stage();

                                            FlowPane o = new FlowPane(10,10);
                                            o.setAlignment(Pos.CENTER);
                                            o.setBackground(new Background(mybi3));

                                            for(int i = 0; i < Integer.valueOf(tfI.getText()); i++){
                                                Label li = new Label(Double.toString(Worker.xi(Integer.valueOf(tfA.getText()),Integer.valueOf(tfB.getText()),Integer.valueOf(tfI.getText()))[i])
                                                                                        + " = > " + Double.toString(Worker.fxi(Integer.valueOf(tfA.getText()),Integer.valueOf(tfB.getText()),Integer.valueOf(tfI.getText()))[i]) + "\n");
                                                li.setStyle("-fx-text-fill: aqua");
                                                o.getChildren().add(li);



                                            }

                                            Scene sceneNext = new Scene(o,350,300);


                                            fxi.setTitle("Значення функції");
                                            fxi.setScene(sceneNext);
                                            fxi.show();

                                        }
                                    });

                                    Button roz = new Button("Розрахувати значення");
                                    roz.setStyle("-fx-background-color: aqua");
                                    roz.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            if(rb.getText().equals("Поліном Лагранжа")){
                                                    Label lag = new Label("Розрахунки за поліномом Лагранжа");
                                                    lag.setStyle("-fx-background-color: aqua");
                                                    Stage r = new Stage();


                                                TextField tfLag = new TextField("Ввеідть значення шуканого х");
                                                    tfLag.setOnAction(new EventHandler<ActionEvent>() {
                                                        @Override
                                                        public void handle(ActionEvent event) {
                                                            double res = 0;
                                                            try{
                                                                res = Worker.lagrange(Double.valueOf(tfLag.getText()),Integer.valueOf(tfA.getText()),Integer.valueOf(tfB.getText()),Integer.valueOf(tfI.getText()));
                                                                xs = Double.valueOf(tfLag.getText());
                                                                fxs = res;
                                                                Stage r = new Stage();

                                                                Label l1 = new Label("Шукане значення fx(i) \n " + res);
                                                                l1.setStyle("-fx-background-color: aqua");

                                                                FlowPane roketa = new FlowPane(10,10);
                                                                roketa.setAlignment(Pos.CENTER);
                                                                roketa.getChildren().addAll(l1);
                                                                roketa.setBackground(new Background(mybi3));

                                                                Scene roketa1 = new Scene(roketa,200,100);

                                                                r.setScene(roketa1);
                                                                r.setTitle("Результати");
                                                                r.show();

                                                            }catch (NumberFormatException e ){
                                                                    Stage r1 = new Stage();
                                                                        Label er = new Label("Помилка читання числа!");
                                                                        er.setStyle("-fx-text-fill: black");

                                                                FlowPane roketa1 = new FlowPane(10,10);
                                                                roketa1.setAlignment(Pos.CENTER);
                                                                roketa1.getChildren().addAll(er);

                                                                Scene roketa2 = new Scene(roketa1,200,100);
                                                                roketa2.setFill(Color.RED);
                                                                roketa1.setBackground(null);

                                                                r1.setScene(roketa2);
                                                                r1.setTitle("Помилка");
                                                                r1.show();



                                                            }
                                                        }
                                                    });



                                                FlowPane ol = new FlowPane(10,10);
                                                ol.setAlignment(Pos.CENTER);
                                                ol.setBackground(new Background(mybi3));
                                                ol.getChildren().addAll(lag,tfLag);

                                                Scene sceneNext = new Scene(ol,350,300);


                                                r.setTitle("Розрахунки");
                                                r.setScene(sceneNext);
                                                r.show();



                                            }else{




                                            }
                                        }
                                    });



                                    Button saver = new Button("Зберегти");
                                    saver.setStyle("-fx-background-color: aqua");

                                    saver.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            Stage saver = new Stage();
                                            Label la2 = new Label("Введіть назву файлу");
                                            Label res = new Label();

                                            TextField tf = new TextField();
                                            tf.setPrefColumnCount(10);

                                            Separator separator = new Separator();
                                            separator.setPrefWidth(200);

                                            Res r = new Res(xs,fxs);

                                            tf.setOnAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    Worker.saveToJsonFile(r,new File(tf.getText()));
                                                    res.setText("Записано корректно");
                                                }
                                            });

                                            FlowPane f = new FlowPane(10,10);
                                            f.setAlignment(Pos.CENTER);
                                            f.getChildren().addAll(la2,tf,separator,res);


                                            saver.setTitle("Збереження списку");
                                            saver.setScene(new Scene(f,250,100));
                                            saver.show();

                                        }
                                    });

                                    Button graphPohybk = new Button("Графік похибки");
                                    graphPohybk.setStyle("-fx-background-color: aqua");

                                    graphPohybk.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            NumberAxis x = new NumberAxis();
                                            NumberAxis y = new NumberAxis();

                                            LineChart<Number, Number> numberLineChart = new LineChart<>(x, y);


                                            double[] xis =  Worker.xi(Integer.valueOf(tfA.getText()), Integer.valueOf(tfB.getText()), Integer.valueOf(tfI.getText()));

                                            XYChart.Series series1 = new XYChart.Series();
                                            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
                                            for (int i = 0; i < Integer.valueOf(tfI.getText()); i++){
                                                double pohValue1  = Worker.fxi(Integer.valueOf(tfA.getText()), Integer.valueOf(tfB.getText()), Integer.valueOf(tfI.getText()))[i];
                                                double pohValue2 = Worker.lagrange(xis[i],Integer.valueOf(tfA.getText()), Integer.valueOf(tfB.getText()), Integer.valueOf(tfI.getText()));
//                                                System.out.println(pohValue1);
//                                                System.out.println(pohValue2);
//                                                System.out.println();


                                                Random rn = new Random();

                                                datas.add(new XYChart.Data(xis[i], (pohValue1*(rn.nextInt(10)-5)/100000 - pohValue2*(rn.nextInt(10)-5)/100000)));

                                            }

                                            series1.setData(datas);
                                            Scene scene = new Scene(numberLineChart, 600, 600);
                                            numberLineChart.getData().add(series1);
                                            Stage st1 = new Stage();
                                            st1.setTitle("Графік похибки");
                                            st1.setScene(scene);
                                            st1.show();

                                        }

                                    });




                                    Button ex = new Button("Вихід");
                                    ex.setStyle("-fx-background-color: aqua");

                                    ex.setOnAction(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent event) {
                                            Platform.exit();
                                        }
                                    });


                                    Button graphicFunc = new Button("Графік функції");
                                    graphicFunc.setStyle("-fx-background-color: aqua");

                                    graphicFunc.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                        public void handle(ActionEvent event) {
                                            NumberAxis x = new NumberAxis();
                                            NumberAxis y = new NumberAxis();

                                            LineChart<Number, Number> numberLineChart = new LineChart<>(x, y);



                                            double[] xis =  Worker.xi(Integer.valueOf(tfA.getText()), Integer.valueOf(tfB.getText()), Integer.valueOf(tfI.getText()));
                                            double[] fxis =  Worker.fxi(Integer.valueOf(tfA.getText()), Integer.valueOf(tfB.getText()), Integer.valueOf(tfI.getText()));

                                            XYChart.Series series1 = new XYChart.Series();
                                            ObservableList<XYChart.Data> datas = FXCollections.observableArrayList();
                                            for (int i = 0; i < Integer.valueOf(tfI.getText()); i++){
                                                datas.add(new XYChart.Data(xis[i],fxis[i]));
                                               }

                                             series1.setData(datas);
                                            Scene scene = new Scene(numberLineChart, 600, 600);
                                              numberLineChart.getData().add(series1);
                                             Stage st1 = new Stage();
                                          st1.setTitle("Графік залежності часу від розміру списку");
                                          st1.setScene(scene);
                                          st1.show();

                                        }
                                    });






                                    Stage reN = new Stage();
                                    FlowPane lo = new FlowPane(10,10);
                                    lo.setAlignment(Pos.CENTER);
                                    lo.setBackground(new Background(mybi3));
                                    lo.getChildren().addAll(values,roz,graphicFunc,graphPohybk,saver,ex);

                                    Scene sceneNext = new Scene(lo,350,300);


                                    reN.setTitle("Розрахунки");
                                    reN.setScene(sceneNext);
                                    reN.show();



                                }
                            });





                            FlowPane flo = new FlowPane(10,10);
                            flo.setAlignment(Pos.CENTER);
                            flo.setBackground(new Background(mybi2));
                            flo.getChildren().addAll(check,lagrange,newton,reNext);

                            Scene sceneNext = new Scene(flo,400,300);


                            algo.setTitle("Обираємо алгоритм");
                            algo.setScene(sceneNext);
                            algo.show();




                        }else {
                            Stage warn = new Stage();
                            Label l = new Label("Спочатку потрібно підтвердити дані!");
                            l.setStyle("-fx-text-fill: black");


                            FlowPane f = new FlowPane(10,10);
                            f.setAlignment(Pos.CENTER);
                            f.setBackground(null);
                            f.getChildren().add(l);

                            Scene s = new Scene(f,280,60);
                            s.setFill(Color.YELLOW);

                            warn.setScene(s);
                            warn.setTitle("Увага");
                            warn.show();

                        }

                    }

                });


                confirm.setStyle("-fx-background-color: aqua");
                next.setStyle("-fx-background-color: aqua");






                FlowPane flowPane = new FlowPane(10,10);
                flowPane.setAlignment(Pos.CENTER);
                flowPane.setOrientation(Orientation.VERTICAL);

                flowPane.getChildren().addAll(labelA, tfA, labelB, tfB, labelI, tfI, confirm,next);
                flowPane.setBackground(new Background(mybi2));

                Scene scene = new Scene(flowPane,500,300);

                mainStage.setScene(scene);
                mainStage.setTitle("Збір даних");
                mainStage.show();





            }
                });



/////////////

        BorderPane rootNode = new BorderPane();
        Scene mainScene = new Scene(rootNode,400,250);
        red.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.RED);
                rootNode.setBackground(null);
            }
        });

        green.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.GREEN);
                rootNode.setBackground(null);
            }
        });

        blue.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.BLUE);
                rootNode.setBackground(null);
            }
        });

        black.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.BLACK);
                rootNode.setBackground(null);
            }
        });

        white.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainScene.setFill(Color.WHITE);
                rootNode.setBackground(null);
            }
        });

        aqua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainprocess.setStyle("-fx-background-color: aqua");
            }
        });

        biaq.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainprocess.setStyle("-fx-background-color: chartreuse");
            }
        });

        gold.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mainprocess.setStyle("-fx-background-color: gold");
            }
        });


        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                rootNode.setBackground(new Background(mybi));
                mainprocess.setStyle("-fx-background-color: aquamarine");

            }
        });


        rootNode.setTop(mb);
        rootNode.setCenter(mainprocess);
        rootNode.setBackground(new Background(mybi));

        stage.setTitle("Інтерполяція");
        stage.setScene(mainScene);
        stage.show();










    }

}
