#language: es

Característica: Ingresar un nuevo producto
  Yo como usuario quiero crear un nuevo porducto

  Escenario: Ingresar un nuevo producto de manera exitosa
    Dado que el usuario abre la url en el navegador
    Cuando El usuario inicia sesion con sus credenciales
    Y da clic en vientos del norte y clic en producto
    Y damos clic en nuevo producto llenamos los campos y clic en guardar

    Entonces El usuario visualizara el nombre del nuevo producto
    Y se envia el nombre del nuevo producto a excel