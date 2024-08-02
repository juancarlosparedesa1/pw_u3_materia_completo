<template>
  <div class="container">
    <h1>INSERTAR ESTUDIANTE</h1>
    <p type="Cedula"><input type="text" v-model="cedula" /></p>
    <p type="Nombre"><input type="text" v-model="nombre" /></p>
    <p type="Apellido"><input type="text" v-model="apellido" /></p>
    <!--da complicaciones al obtener
      <p type="Fecha Nacimiento">
      <input id="idFechaNacimiento" type="date" />
    </p> -->
    <p type="Carrera"><input type="text" v-model="carrera" /></p>
    <p type="Genero"><input type="text" v-model="genero" /></p>
    <button v-on:click="insertarEstudiante">GUARDAR</button>
    <p v-if="mensaje">{{ mensaje }}</p>
    <!-- Mensaje de éxito -->
  </div>
</template>

<script>
import { guardarFachada } from "../clients/clienteEstudiante.js";
export default {
  //option API
  //data:define el estado reactivo del componente
  data() {
    return {
      //almacenar información que el estudiante ingresa en el formulario
      cedula: "",
      nombre: "",
      apellido: "",
      carrera: "",
      genero: "",
      mensaje: "",
    };
  },
  //metodos que puedo usar en el componente
  methods: {
    insertarEstudiante() {
      //crea un objeto data con los valores actuales almacenados en las
      //propiedades del componenete
      const bodyEstudiante = {
        cedula: this.cedula,
        nombre: this.nombre,
        apellido: this.apellido,
        carrera: this.carrera,
        genero: this.genero,
      };
      guardarFachada(bodyEstudiante);
      this.mensaje = "Estudiante insertado correctamente"; // Actualiza el mensaje
      // Opcional: Limpiar el formulario
      this.cedula = "";
      this.nombre = "";
      this.apellido = "";
      this.carrera = "";
      this.genero = "";
    },
  },
};
</script>

<style>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
p:before {
  content: attr(type);
  display: block;
}
p {
  text-align: left;
  margin-bottom: 0px;
}
input {
  margin-bottom: 0px;
}
h1 {
  margin-bottom: 0px; /* Ajusta según sea necesario */
}
button {
  margin-top: 20px;
}
</style>

