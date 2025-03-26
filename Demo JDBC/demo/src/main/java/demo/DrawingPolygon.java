package demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;

public class DrawingPolygon extends Application { 
   @Override
   public void start(Stage stage) { 
      // Crear un rectángulo normal
      Rectangle rectangle = new Rectangle();
      rectangle.setX(50); // Posición en X
      rectangle.setY(50); // Posición en Y
      rectangle.setWidth(200); // Ancho
      rectangle.setHeight(100); // Altura

      // Crear un rectángulo redondeado
      Rectangle roundedRectangle = new Rectangle();
      roundedRectangle.setX(300); // Posición en X
      roundedRectangle.setY(50); // Posición en Y
      roundedRectangle.setWidth(200); // Ancho
      roundedRectangle.setHeight(100); // Altura
      roundedRectangle.setArcWidth(30); // Radio de arco en las esquinas
      roundedRectangle.setArcHeight(30); // Radio de arco en las esquinas

      // Crear un círculo
      Circle circle = new Circle();
      circle.setCenterX(150); // Coordenada X del centro del círculo
      circle.setCenterY(200); // Coordenada Y del centro del círculo
      circle.setRadius(50); // Radio del círculo

      // Crear una elipse
      Ellipse ellipse = new Ellipse();
      ellipse.setCenterX(450); // Coordenada X del centro de la elipse
      ellipse.setCenterY(200); // Coordenada Y del centro de la elipse
      ellipse.setRadiusX(100); // Radio horizontal de la elipse
      ellipse.setRadiusY(50); // Radio vertical de la elipse

      // Crear una polilínea
      Polyline polyline = new Polyline();
      polyline.getPoints().addAll(new Double[]{
         50.0, 350.0, // Punto inicial
         100.0, 400.0, // Segundo punto
         150.0, 350.0, // Tercer punto
         200.0, 400.0  // Cuarto punto
      });
      polyline.setStrokeWidth(2); // Grosor de la polilínea

      // Crear una curva cúbica
      CubicCurve cubicCurve = new CubicCurve();
      cubicCurve.setStartX(50); // Inicio de la curva
      cubicCurve.setStartY(450); // Inicio de la curva
      cubicCurve.setControlX1(100); // Primer punto de control
      cubicCurve.setControlY1(500); // Primer punto de control
      cubicCurve.setControlX2(200); // Segundo punto de control
      cubicCurve.setControlY2(400); // Segundo punto de control
      cubicCurve.setEndX(300); // Fin de la curva
      cubicCurve.setEndY(450); // Fin de la curva
      cubicCurve.setStrokeWidth(2); // Grosor de la curva cúbica


      // Crear una curva cuadrática
      QuadCurve quadCurve = new QuadCurve();
      quadCurve.setStartX(50); // Inicio de la curva cuadrática
      quadCurve.setStartY(550); // Inicio de la curva cuadrática
      quadCurve.setControlX(150); // Punto de control
      quadCurve.setControlY(600); // Punto de control
      quadCurve.setEndX(250); // Fin de la curva cuadrática
      quadCurve.setEndY(550); // Fin de la curva cuadrática
      quadCurve.setStrokeWidth(2); // Grosor de la curva cuadrática


      // Crear un arco abierto
      Arc arcOpen = new Arc();
      arcOpen.setCenterX(150); // Centro del arco
      arcOpen.setCenterY(700); // Centro del arco
      arcOpen.setRadiusX(100); // Radio horizontal del arco
      arcOpen.setRadiusY(50); // Radio vertical del arco
      arcOpen.setStartAngle(0); // Ángulo de inicio
      arcOpen.setLength(180); // Longitud del arco
      arcOpen.setType(ArcType.OPEN); // Tipo de arco
      arcOpen.setStrokeWidth(2); // Grosor del arco

      // Crear un arco redondo
      Arc arcRound = new Arc();
      arcRound.setCenterX(300); // Centro del arco
      arcRound.setCenterY(700); // Centro del arco
      arcRound.setRadiusX(100); // Radio horizontal del arco
      arcRound.setRadiusY(50); // Radio vertical del arco
      arcRound.setStartAngle(0); // Ángulo de inicio
      arcRound.setLength(180); // Longitud del arco
      arcRound.setType(ArcType.ROUND); // Tipo de arco

      // Crear un arco acordonado
      Arc arcChord = new Arc();
      arcChord.setCenterX(450); // Centro del arco
      arcChord.setCenterY(700); // Centro del arco
      arcChord.setRadiusX(100); // Radio horizontal del arco
      arcChord.setRadiusY(50); // Radio vertical del arco
      arcChord.setStartAngle(0); // Ángulo de inicio
      arcChord.setLength(180); // Longitud del arco
      arcChord.setType(ArcType.CHORD); // Tipo de arco
  

      // Crear un triángulo invertido con SVGPath
      SVGPath triangle = new SVGPath();
      String trianglePath = "M 150 800 L 250 800 L 200 900 Z"; // Definición del triángulo invertido
      triangle.setContent(trianglePath);
  

      // Crear un grupo para contener todas las formas
      Group group = new Group(rectangle, roundedRectangle, circle, ellipse, polyline, cubicCurve, quadCurve, arcOpen, arcRound, arcChord, triangle);

      // Crear una escena con el grupo
      Scene scene = new Scene(group, 600, 1000);

      // Establecer la escena en el escenario (Stage)
      stage.setTitle("Dibujando Formas");
      stage.setScene(scene);
      stage.show(); // Mostrar el escenario
   }
   
   public static void main(String args[]){ 
      launch(args); 
   } 
}
