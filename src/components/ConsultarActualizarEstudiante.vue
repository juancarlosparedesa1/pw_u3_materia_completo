<template>
  <h1>Consultar-Actualizar Estudiante</h1>
  <p type="cedula"><input type="text" v-model="cedula" /></p>
  <p type="Nombre"><input type="text" v-model="nombre" /></p>
  <p type="Apellido"><input type="text" v-model="apellido" /></p>
  <p type="Carrera"><input type="text" v-model="carrera" /></p>
  <p type="Genero"><input type="text" v-model="genero" /></p>
  <button v-on:click="actualizar">Actualizar</button>
  <button v-on:click="consultar">Buscar</button>
  <p v-if="mensaje">{{ mensaje }}</p>
</template>

<script>
import { buscarPorCedulaFachada,actualizarPorCedulaFachada } from "../clients/clienteEstudiante.js";
export default {
  //almaceno información del estudiante que se ingresa en el formulario
  data() {
    return {
      cedula: null,
      nombre: "",
      apellido: "",
      carrera: "",
      genero: "",
      mensaje:"",
    };
  },
  methods: {
    async consultar() {
      if (!this.cedula) {
        console.error("La cédula no puede estar vacía");
        return;
      }

      try {
        const data = await buscarPorCedulaFachada(this.cedula);
        this.mensaje="Estudiante encontrado"
        if (!data) {
          console.error(
            "No se encontró información para la cédula proporcionada"
          );
          return;
        }

        this.cedula = data.cedula;
        this.nombre = data.nombre;
        this.apellido = data.apellido;
        this.carrera = data.carrera;
        this.genero = data.genero;
      } catch (error) {
        console.error("Error al buscar la cédula:", error);
      }
    },
    actualizar(){
        const bodyEstudiante={
            cedula:this.cedula,
            nombre:this.nombre,
            apellido:this.apellido,
            carrera:this.carrera,
            genero:this.genero,
            
        }
        const data= actualizarPorCedulaFachada(this.cedula,bodyEstudiante)
        this.mensaje="Estudiante actualiado";

    }
  },
};
</script>

<style>
</style>