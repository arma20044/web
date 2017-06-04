package py.edu.ucsa.voto.dao;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.jdbc.driver.DatabaseError;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONTokener;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import py.edu.ucsa.voto.entity.Generic;
import py.edu.ucsa.voto.entity.UcsawsCandidatos;
import py.edu.ucsa.voto.entity.UcsawsDepartamento;
import py.edu.ucsa.voto.entity.UcsawsDistrito;
import py.edu.ucsa.voto.entity.UcsawsEvento;
import py.edu.ucsa.voto.entity.UcsawsGenero;
import py.edu.ucsa.voto.entity.UcsawsListas;
import py.edu.ucsa.voto.entity.UcsawsLocal;
import py.edu.ucsa.voto.entity.UcsawsMesa;
import py.edu.ucsa.voto.entity.UcsawsNacionalidad;
import py.edu.ucsa.voto.entity.UcsawsPais;
import py.edu.ucsa.voto.entity.UcsawsPersona;
import py.edu.ucsa.voto.entity.UcsawsTipoEvento;
import py.edu.ucsa.voto.entity.UcsawsTipoLista;
import py.edu.ucsa.voto.entity.UcsawsUsers;
import py.edu.ucsa.voto.entity.UcsawsVotante;
import py.edu.ucsa.voto.entity.UcsawsVotos;
import py.edu.ucsa.voto.entity.UcsawsVotosBlanco;
import py.edu.ucsa.voto.entity.UcsawsZona;
import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoRequest;
import py.edu.ucsa.voto.ws.schema.beans.QueryGenericoResponse;

@Repository("canalizadorDAO")
@Transactional(readOnly = true)
public class CanalizadorDAO {

  @Autowired
  EventoDAOInterface eventoDAO;

  @Autowired
  UsersDAOInterface usersDAO;

  @Autowired
  VotanteDAOInterface votanteDAO;

  @Autowired
  ListasDAOInterface listasDAO;

  @Autowired
  VotoDAOInterface votoDAO;

  @Autowired
  MesaDAOInterface mesaDAO;

  @Autowired
  TipoListasDAOInterface tipoListasDAO;

  @Autowired
  TipoEventoDAOInterface tipoEventoDAO;

  @Autowired
  GeneroDAOInterface generoDAO;

  @Autowired
  PersonaDAOInterface personaDAO;

  @Autowired
  PaisDAOInterface paisDAO;

  @Autowired
  NacionalidadDAOInterface nacionalidadDAO;

  @Autowired
  DepartamentoDAOInterface departamentoDAO;

  @Autowired
  DistritoDAOInterface distritoDAO;

  @Autowired
  ZonaDAOInterface zonaDAO;

  @Autowired
  LocalDAOInterface localDAO;

  @Autowired
  TipoListasDAOInterface tipoListaDAO;

  @Autowired
  CandidatosDAOInterface candidatosDAO;



  @Transactional
  public QueryGenericoResponse parearClase(QueryGenericoRequest request) throws JsonParseException,
      JsonMappingException, IOException {
    QueryGenericoResponse response = new QueryGenericoResponse();
    if (request.getTipo_query_generico() == 1) {// consultar clase
      // UCSAWS_EVENTO

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      Date fecha = mapper.readValue(jsonInString, Date.class);

      UcsawsEvento r = eventoDAO.obtenerEventoByFecha(fecha);
      if (r.getIdEvento() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);

        // py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento
        // eventoSinMapeo = new
        // py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento();
        // eventoSinMapeo.setDescripcion(r.getDescripcion());

        ObjectMapper mapperObj = new ObjectMapper();

        // printter

        ObjectMapper mapper2 = new ObjectMapper();
        // System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(eventoSinMapeo));

        // mapperObj.setVisibility(JsonMethod.FIELD, Visibility.ANY);
        // mapperObj.enable(DeserializationConfig.);
        String jsonStr = "";
        try {
          // get Employee object as a json string
          String json = mapper.writeValueAsString(r);
          mapperObj.writeValue(System.out, r);
          System.out.println(jsonStr);
          jsonStr = mapperObj.writeValueAsString(r);
          System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(r));

        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();

        }
        // JSONArray filas =
        // String obj2= filas.toJSONString();

        response.setQuery_generico_response(jsonStr);
      }

      // guardar EVENTO
    } else if (request.getTipo_query_generico() == 2) {// insertar clase //
      // UCSAWS_EVENTO

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsEvento evento = mapper.readValue(jsonInString, UcsawsEvento.class);

      evento.setUsuarioIns("sistema");
      evento.setFchIns(new Date());

      UcsawsEvento comprobar = (UcsawsEvento) eventoDAO.save(evento);
      if (comprobar.getIdEvento() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    } else if (request.getTipo_query_generico() == 3) {// eliminar clase //
      // UCSAWS_EVENTO

      // json string to java object;

      UcsawsEvento evento =
          eventoDAO.obtenerEventoById(Integer.parseInt(request.getQuery_generico()));

      try {
        eventoDAO.delete(evento);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    } else if (request.getTipo_query_generico() == 4) {// modificar clase
      // UCSAWS_EVENTO

    } else if (request.getTipo_query_generico() == 5) {// consultar clase
      // UCSAWS_USERS

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsUsers u = mapper.readValue(jsonInString, UcsawsUsers.class);

      UcsawsUsers r = usersDAO.consultarUsuario(u.getUsuario(), u.getPass());
      if (r.getIdUser() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);

        // py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento
        // eventoSinMapeo = new
        // py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento();
        // eventoSinMapeo.setDescripcion(r.getDescripcion());

        ObjectMapper mapperObj = new ObjectMapper();

        // printter

        ObjectMapper mapper2 = new ObjectMapper();
        // System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(eventoSinMapeo));

        // mapperObj.setVisibility(JsonMethod.FIELD, Visibility.ANY);
        // mapperObj.enable(DeserializationConfig.);
        String jsonStr = "";
        try {
          // get Employee object as a json string
          String json = mapper.writeValueAsString(r);
          mapperObj.writeValue(System.out, r);
          System.out.println(jsonStr);
          jsonStr = mapperObj.writeValueAsString(r);
          System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(r));

        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();

        }
        // JSONArray filas =
        // String obj2= filas.toJSONString();

        response.setQuery_generico_response(jsonStr);
      }
    }

    // consultar
    // insertar
    // eliminar
    // modificar
    else if (request.getTipo_query_generico() == 6) { // consultar votante

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      // String u = mapper.readValue(jsonInString, ArrayList.class);

      UcsawsVotante r = votanteDAO.obtenerVotante(Integer.parseInt(jsonInString));
      if (r.getIdVotante() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);

        // py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento
        // eventoSinMapeo = new
        // py.edu.ucsa.voto.entidadesSinMapeo.UcsawsEvento();
        // eventoSinMapeo.setDescripcion(r.getDescripcion());

        ObjectMapper mapperObj = new ObjectMapper();

        // printter

        ObjectMapper mapper2 = new ObjectMapper();
        // System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(eventoSinMapeo));

        // mapperObj.setVisibility(JsonMethod.FIELD, Visibility.ANY);
        // mapperObj.enable(DeserializationConfig.);
        String jsonStr = "";
        try {
          // get Employee object as a json string
          String json = mapper.writeValueAsString(r);
          mapperObj.writeValue(System.out, r);
          System.out.println(jsonStr);
          jsonStr = mapperObj.writeValueAsString(r);
          System.out.println(mapper2.writerWithDefaultPrettyPrinter().writeValueAsString(r));

        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();

        }
        // JSONArray filas =
        // String obj2= filas.toJSONString();

        response.setQuery_generico_response(jsonStr);
      }
    }

    // consultar usuario + contraseña UCSAWS_USERS
    else if (request.getTipo_query_generico() == 7) {

      // json string to List<String>;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      List<String> lista = mapper.readValue(jsonInString, List.class);

      UcsawsUsers users = new UcsawsUsers();

      users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (users.getIdUser() != null) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(users);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(users);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    else if (request.getTipo_query_generico() == 8) {// modificar clase
      // UCSAWS_USERS
    }

    else if (request.getTipo_query_generico() == 9) {// INSERTAR clase
      // //verificarDatos2
      // UCSAWS_VOTANTE
      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      String id = mapper.readValue(jsonInString, String.class);

      UcsawsVotante r = votanteDAO.obtenerVotanteSinSufragar(id);
      if (r.getIdVotante() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);

        String jsonStr = "";
        try {
          // get Employee object as a json string
          ObjectMapper mapperObj = new ObjectMapper();
          String json = mapper.writeValueAsString(r);
          mapperObj.writeValue(System.out, r);
          System.out.println(jsonStr);
          jsonStr = mapperObj.writeValueAsString(r);
          System.out.println(mapperObj.writerWithDefaultPrettyPrinter().writeValueAsString(r));

          response.setQuery_generico_response(jsonStr);
        } catch (Exception e) {
          System.out.println(e);
        }
      }
    } else if (request.getTipo_query_generico() == 10) {

    } else if (request.getTipo_query_generico() == 11) {

    } else if (request.getTipo_query_generico() == 12) {

    }

    else if (request.getTipo_query_generico() == 13) { // obtenerLista

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      List<Integer> lista = mapper.readValue(jsonInString, List.class);

      UcsawsListas l = listasDAO.obtenerLista(lista.get(0), lista.get(1), lista.get(2));
      if (l.getIdLista() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);

        String jsonStr = "";
        try {
          // get Employee object as a json string
          ObjectMapper mapperObj = new ObjectMapper();

          jsonStr = mapperObj.writeValueAsString(l);

          response.setQuery_generico_response(jsonStr);
        } catch (Exception e) {
          System.out.println(e);
        }
      }
    } else if (request.getTipo_query_generico() == 14) {

    } else if (request.getTipo_query_generico() == 15) {

    } else if (request.getTipo_query_generico() == 16) {

    }

    // VOTO
    else if (request.getTipo_query_generico() == 17) { // Insert VOTO
      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      List<Integer> lista = mapper.readValue(jsonInString, List.class);

      UcsawsVotos voto = new UcsawsVotos();

      UcsawsListas l = listasDAO.obtenerListaByID(lista.get(0));
      UcsawsMesa mesa = mesaDAO.obtenerMesaById(lista.get(1));

      voto.setIdMesa(mesa);
      voto.setIdLista(l);
      voto.setUsuarioIns("sistema");
      voto.setFchIns(new Date());

      Object comprobar = votoDAO.save(voto);
      if (comprobar == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }
    } else if (request.getTipo_query_generico() == 18) {

    } else if (request.getTipo_query_generico() == 19) {

    } else if (request.getTipo_query_generico() == 20) {

      // inicio tipolista
    } else if (request.getTipo_query_generico() == 21) {// obtener Tipo
      // Lista by codigo

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      List<String> lista = mapper.readValue(jsonInString, List.class);

      UcsawsTipoLista tipoLista =
          listasDAO.obtenerLista(lista.get(0), Integer.parseInt(lista.get(1)),
              Integer.parseInt(lista.get(2))).getUcsawsTipoLista();

      if (tipoLista.getIdTipoLista() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);

        String jsonStr = "";
        try {
          // get Employee object as a json string
          ObjectMapper mapperObj = new ObjectMapper();

          jsonStr = mapperObj.writeValueAsString(tipoLista);

          response.setQuery_generico_response(jsonStr);
        } catch (Exception e) {
          System.out.println(e);
        }
      }
    } else if (request.getTipo_query_generico() == 22) {

    } else if (request.getTipo_query_generico() == 23) {

    } else if (request.getTipo_query_generico() == 24) {

    }

    // inicio voto blanco
    else if (request.getTipo_query_generico() == 25) {
      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      List<Integer> lista = mapper.readValue(jsonInString, List.class);

      UcsawsVotosBlanco votoBlanco = new UcsawsVotosBlanco();

      UcsawsTipoLista tipoLista = tipoListasDAO.obtenerTipoListaById(lista.get(0));
      UcsawsMesa mesa = mesaDAO.obtenerMesaById(lista.get(1));
      UcsawsEvento evento = eventoDAO.obtenerEventoById(lista.get(2));

      votoBlanco.setIdTipoLista(tipoLista);
      votoBlanco.setIdMesa(mesa);
      votoBlanco.setIdEvento(evento);

      votoBlanco.setUsuarioIns("sistema");
      votoBlanco.setFchIns(new Date());

      Object comprobar = votoDAO.save(votoBlanco);
      if (comprobar == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }
    } else if (request.getTipo_query_generico() == 26) {

    } else if (request.getTipo_query_generico() == 27) {

    } else if (request.getTipo_query_generico() == 28) {

    }

    // actualizar votante by id votante
    else if (request.getTipo_query_generico() == 29) {
      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      Integer idVotante = mapper.readValue(jsonInString, Integer.class);

      UcsawsVotante votante = new UcsawsVotante();
      votante = votanteDAO.obtenerVotanteById(idVotante);

      votante.setFchUpd(new Date());
      votante.setUsuarioUpd("sistema");
      votante.setSufrago(1);

      Object comprobar = votoDAO.update(votante);
      if (comprobar == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }
    }

    // consultar todos los eventos
    else if (request.getTipo_query_generico() == 30) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      List<UcsawsEvento> evento = new ArrayList<UcsawsEvento>();
      evento = eventoDAO.getList();

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(evento.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // consultar todos los tipos de eventos
    else if (request.getTipo_query_generico() == 31) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      List<UcsawsTipoEvento> evento = new ArrayList<UcsawsTipoEvento>();
      evento = tipoEventoDAO.getList();

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(evento.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // consultar tipo evento by ID
    else if (request.getTipo_query_generico() == 32) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      UcsawsTipoEvento evento = new UcsawsTipoEvento();
      evento = tipoEventoDAO.obtenerTipoEventoById(Integer.parseInt(request.getQuery_generico()));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (evento.getIdTipoEvento() != null) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    else if (request.getTipo_query_generico() == 33) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      UcsawsEvento evento = new UcsawsEvento();
      evento = eventoDAO.obtenerEventoByCodigo(request.getQuery_generico());

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(evento.getIdEvento() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    else if (request.getTipo_query_generico() == 34) {

      // json string to List<String>;
      ObjectMapper mapper = new ObjectMapper();
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
      mapper.setDateFormat(df);
      String jsonInString = request.getQuery_generico();
      Generic g = mapper.readValue(jsonInString, Generic.class);

      UcsawsEvento evento = new UcsawsEvento();
      evento = eventoDAO.obtenerEventoByRangoFechaTipoEvento(g);

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(evento.getIdEvento() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    else if (request.getTipo_query_generico() == 35) {

      // json string to List<String>;
      ObjectMapper mapper = new ObjectMapper();
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
      mapper.setDateFormat(df);
      String jsonInString = request.getQuery_generico();
      Generic g = mapper.readValue(jsonInString, Generic.class);

      UcsawsEvento evento = new UcsawsEvento();
      evento = eventoDAO.obtenerEventoByRangoFechaEvento(g);

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(evento.getIdEvento() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // actualizar evento
    else if (request.getTipo_query_generico() == 36) {
      // json string to java object;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();

      System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonInString));

      UcsawsEvento evento = mapper.readValue(jsonInString, UcsawsEvento.class);

      evento.setFchUpd(new Date());
      evento.setUsuarioUpd("sistema");

      Object comprobar = eventoDAO.update(evento);
      if (comprobar == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }
    }

    // obtener evento by id
    else if (request.getTipo_query_generico() == 37) {
      // json string to java object;

      String id = request.getQuery_generico();

      Integer idEvento = Integer.parseInt(id);

      UcsawsEvento evento = new UcsawsEvento();
      evento = eventoDAO.obtenerEventoById(idEvento);

      // evento.setFchUpd(new Date());
      // evento.setUsuarioUpd("sistema");

      // Object comprobar = eventoDAO.update(evento);
      if (evento.getIdEvento() == null) {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(evento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }
    }

    // consultar todos los GENEROS
    else if (request.getTipo_query_generico() == 38) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      List<UcsawsGenero> genero = new ArrayList<UcsawsGenero>();
      genero = generoDAO.getList();

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(genero.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(genero);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(genero);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // consultar GENEROS por evento
    else if (request.getTipo_query_generico() == 39) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      String idEvento = mapper.readValue(jsonInString, String.class);

      List<UcsawsGenero> genero = new ArrayList<UcsawsGenero>();
      genero = generoDAO.obtenerGeneroByIdEvento(Integer.parseInt(idEvento));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(genero.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(genero);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(genero);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // consultar codigo de GENERO e por ID evento
    else if (request.getTipo_query_generico() == 40) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      List<String> codigoGeneroidEvento = mapper.readValue(jsonInString, List.class);

      List<UcsawsGenero> genero = new ArrayList<UcsawsGenero>();
      genero =
          generoDAO.obtenerGeneroByCodigoGEneroIdEvento(codigoGeneroidEvento.get(0),
              Integer.parseInt(codigoGeneroidEvento.get(1)));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(genero.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(genero);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(genero);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

      // guardar GENERO
    } else if (request.getTipo_query_generico() == 41) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsGenero genero = mapper.readValue(jsonInString, UcsawsGenero.class);

      // genero.setUsuarioIns("sistema");
      genero.setFchIns(new Date());

      UcsawsGenero comprobar = (UcsawsGenero) generoDAO.save(genero);
      if (comprobar.getIdGenero() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ELIMINAR GENERO
    else if (request.getTipo_query_generico() == 42) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsGenero genero = mapper.readValue(jsonInString, UcsawsGenero.class);

      try {
        generoDAO.delete(genero);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }
    // CONSULTAR GENERO BY ID
    else if (request.getTipo_query_generico() == 43) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      String idGenero = mapper.readValue(jsonInString, String.class);

      List<UcsawsGenero> genero = new ArrayList<UcsawsGenero>();
      genero = generoDAO.obtenerGeneroById(Integer.parseInt(idGenero));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(genero.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(genero.get(0));
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(genero.get(0));
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // consultar PERSONAS by evento
    else if (request.getTipo_query_generico() == 44) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      List<UcsawsPersona> persona = new ArrayList<UcsawsPersona>();
      persona = personaDAO.obtenerPersonaByEvento(Integer.parseInt(request.getQuery_generico()));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(persona.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(persona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(persona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // consultar PAISES by evento
    else if (request.getTipo_query_generico() == 45) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      List<UcsawsPais> pais = new ArrayList<UcsawsPais>();
      pais = paisDAO.obtenerPaisByEvento(Integer.parseInt(request.getQuery_generico()));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(pais.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(pais);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(pais);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // consultar NACIONALIDAD by evento
    else if (request.getTipo_query_generico() == 46) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      String id = mapper.readValue(jsonInString, String.class);

      List<UcsawsNacionalidad> nacionalidad = new ArrayList<UcsawsNacionalidad>();
      nacionalidad = nacionalidadDAO.obtenerNacionalidadByEvento(Integer.parseInt(id));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(nacionalidad.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(nacionalidad);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(nacionalidad);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // consultar por nombre pais y por ID evento
    else if (request.getTipo_query_generico() == 47) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      List<String> codigoGeneroidEvento = mapper.readValue(jsonInString, List.class);

      UcsawsPais pais = new UcsawsPais();
      pais =
          paisDAO.obtenerPaisByNombreYEvento(codigoGeneroidEvento.get(0),
              Integer.parseInt(codigoGeneroidEvento.get(1)), codigoGeneroidEvento.get(2));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (pais.getIdPais() != null) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(pais);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(pais);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

      // guardar GENERO
    }

    // guardar pais
    else if (request.getTipo_query_generico() == 48) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsPais pais = mapper.readValue(jsonInString, UcsawsPais.class);

      // pais.setUsuarioIns("sistema");
      pais.setFchIns(new Date());

      UcsawsPais comprobar = (UcsawsPais) paisDAO.save(pais);
      if (comprobar.getIdPais() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // OBTENER NACIONALIDAD BY CODIGO Y NOMBRE (VALIDACION)
    else if (request.getTipo_query_generico() == 49) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      List<String> lista = mapper.readValue(jsonInString, List.class);

      UcsawsNacionalidad nacionalidad = new UcsawsNacionalidad();
      nacionalidad =
          nacionalidadDAO.obtenerNacionalidadByCodigoYNombre(lista.get(0), lista.get(1),
              Integer.parseInt(lista.get(2)));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      // parseo json
      ObjectMapper mapperObj = new ObjectMapper();
      String jsonStr = "";
      try {
        // get Employee object as a json string
        jsonStr = mapperObj.writeValueAsString(nacionalidad);
        System.out.println(jsonStr);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      response.setCodigo(2244);
      response.setQuery_generico_response(jsonStr);

    }

    // consultar pais por id
    else if (request.getTipo_query_generico() == 50) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      String idPais = mapper.readValue(jsonInString, String.class);

      UcsawsPais pais = new UcsawsPais();
      pais = paisDAO.obtenerPaisById(Integer.parseInt(idPais));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      // parseo json
      ObjectMapper mapperObj = new ObjectMapper();
      String jsonStr = "";
      try {
        // get Employee object as a json string
        jsonStr = mapperObj.writeValueAsString(pais);
        System.out.println(jsonStr);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      response.setCodigo(2244);
      response.setQuery_generico_response(jsonStr);

    }

    // guardar NACIONALIDAD
    else if (request.getTipo_query_generico() == 51) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsNacionalidad nacionalidad = mapper.readValue(jsonInString, UcsawsNacionalidad.class);

      // genero.setUsuarioIns("sistema");
      nacionalidad.setFchIns(new Date());

      UcsawsNacionalidad comprobar = (UcsawsNacionalidad) nacionalidadDAO.save(nacionalidad);
      if (comprobar.getIdNacionalidad() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // consultar nacionalidades con este pais y evento
    else if (request.getTipo_query_generico() == 52) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      List<String> lista = mapper.readValue(jsonInString, List.class);

      // UcsawsPais pais = new UcsawsPais();
      // pais =
      // paisDAO.obtenerPaisByIdYEvento(Integer.parseInt(lista.get(0)),
      // Integer.parseInt(lista.get(1)));

      UcsawsNacionalidad n = new UcsawsNacionalidad();
      n =
          nacionalidadDAO.obtenerNacionalidadByPaisyEvento(Integer.parseInt(lista.get(0)),
              Integer.parseInt(lista.get(1)));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      // parseo json
      ObjectMapper mapperObj = new ObjectMapper();
      String jsonStr = "";
      try {
        // get Employee object as a json string
        jsonStr = mapperObj.writeValueAsString(n);
        System.out.println(jsonStr);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      response.setCodigo(2244);
      response.setQuery_generico_response(jsonStr);

    }

    // ELIMINAR NACIONALIDAD
    else if (request.getTipo_query_generico() == 53) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsNacionalidad nacionalidad = mapper.readValue(jsonInString, UcsawsNacionalidad.class);

      try {
        nacionalidadDAO.delete(nacionalidad);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // consultar NACIONALIDAD by id
    else if (request.getTipo_query_generico() == 54) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      String id = mapper.readValue(jsonInString, String.class);

      UcsawsNacionalidad nacionalidad = new UcsawsNacionalidad();
      nacionalidad = nacionalidadDAO.obtenerNacionalidadByID(Integer.parseInt(id));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(nacionalidad.getIdNacionalidad() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(nacionalidad);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(nacionalidad);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // actualizar update nacionalidad
    else if (request.getTipo_query_generico() == 55) {
      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsNacionalidad nacionalidad = mapper.readValue(jsonInString, UcsawsNacionalidad.class);
      nacionalidad.setFchUpd(new Date());

      Object comprobar = nacionalidadDAO.update(nacionalidad);
      if (comprobar == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }
    }

    // consultar nacionalidades by id pais
    else if (request.getTipo_query_generico() == 56) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      String idPais = mapper.readValue(jsonInString, String.class);

      // UcsawsPais pais = new UcsawsPais();
      // pais =
      // paisDAO.obtenerPaisByIdYEvento(Integer.parseInt(lista.get(0)),
      // Integer.parseInt(lista.get(1)));

      UcsawsNacionalidad n = new UcsawsNacionalidad();
      n = nacionalidadDAO.obtenerNacionalidadByPais((Integer.parseInt(idPais)));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      // parseo json
      ObjectMapper mapperObj = new ObjectMapper();
      String jsonStr = "";
      try {
        // get Employee object as a json string
        jsonStr = mapperObj.writeValueAsString(n);
        System.out.println(jsonStr);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      response.setCodigo(2244);
      response.setQuery_generico_response(jsonStr);

    }

    // consultar PAISES by evento que no esten en la tabla nacionalidades
    else if (request.getTipo_query_generico() == 57) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      List<UcsawsPais> pais = new ArrayList<UcsawsPais>();
      pais =
          paisDAO
              .obtenerPaisByEventoFueraNacionalidad(Integer.parseInt(request.getQuery_generico()));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(pais.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(pais);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(pais);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }
    // guardar PERSONA
    else if (request.getTipo_query_generico() == 58) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsPersona persona = mapper.readValue(jsonInString, UcsawsPersona.class);

      // genero.setUsuarioIns("sistema");
      persona.setFchIns(new Date());

      UcsawsPersona comprobar = (UcsawsPersona) personaDAO.save(persona);
      if (comprobar.getIdPersona() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // consultar PERSONAS by cedula
    else if (request.getTipo_query_generico() == 59) {

      // json string to List<String>;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      String cedula = mapper.readValue(jsonInString, String.class);

      List<UcsawsPersona> persona = new ArrayList<UcsawsPersona>();
      persona = personaDAO.obtenerPersonaByCedula(Integer.parseInt(cedula));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(persona.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(persona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(persona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // eliminar delete persona
    else if (request.getTipo_query_generico() == 60) {

      UcsawsPersona persona =
          personaDAO.obtenerPersonaByIdPersona((Integer.parseInt(request.getQuery_generico())));

      try {
        personaDAO.delete(persona);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // consultar PERSONAS by idPersona
    else if (request.getTipo_query_generico() == 61) {

      // json string to List<String>;

      // ObjectMapper mapper = new ObjectMapper();
      // String jsonInString = ;
      // String cedula = mapper.readValue(jsonInString, String.class);

      UcsawsPersona persona =
          personaDAO.obtenerPersonaByIdPersona(Integer.parseInt(request.getQuery_generico()));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (persona.getIdPersona() != null) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(persona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(new UcsawsPersona());
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // actualizar persona modificar update
    else if (request.getTipo_query_generico() == 62) {
      // json string to java object;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();

      System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonInString));

      UcsawsPersona persona = mapper.readValue(jsonInString, UcsawsPersona.class);

      Object comprobar = personaDAO.update(persona);
      if (comprobar == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(persona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }
    }

    // eliminar PAIS
    else if (request.getTipo_query_generico() == 63) {

      UcsawsPais pais = paisDAO.obtenerPaisById((Integer.parseInt(request.getQuery_generico())));

      try {
        paisDAO.delete(pais);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // consultar TIPO EVENTO by evento
    else if (request.getTipo_query_generico() == 64) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      List<UcsawsTipoEvento> tipoEvento = new ArrayList<UcsawsTipoEvento>();
      tipoEvento =
          tipoEventoDAO
              .obtenerTipoEventoByIdEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(tipoEvento.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(tipoEvento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(tipoEvento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }
    // guardar TIPO EVENTO
    else if (request.getTipo_query_generico() == 65) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsTipoEvento tipoEvento = mapper.readValue(jsonInString, UcsawsTipoEvento.class);

      // genero.setUsuarioIns("sistema");
      tipoEvento.setFchIns(new Date());

      UcsawsTipoEvento comprobar = (UcsawsTipoEvento) tipoEventoDAO.save(tipoEvento);
      if (comprobar.getIdTipoEvento() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ELIMINAR DELETE TIPO EVENTO
    else if (request.getTipo_query_generico() == 66) {

      UcsawsTipoEvento tipoEvento =
          tipoEventoDAO.obtenerTipoEventoById((Integer.parseInt(request.getQuery_generico())));

      try {
        tipoEventoDAO.delete(tipoEvento);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // DEPARTAMENTOS BY ID EVENTO
    else if (request.getTipo_query_generico() == 67) {
      List<UcsawsDepartamento> departamento = new ArrayList<UcsawsDepartamento>();
      departamento =
          departamentoDAO.obtenerDepartamentoByIdEvento((Integer.parseInt(request
              .getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(departamento.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(departamento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(departamento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // guardar DEPARTAMENTO
    else if (request.getTipo_query_generico() == 68) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsDepartamento departamento = mapper.readValue(jsonInString, UcsawsDepartamento.class);

      // genero.setUsuarioIns("sistema");
      // tipoEvento.setFchIns(new Date());
      // departamento.setIdDepartamento(null);

      UcsawsDepartamento comprobar = (UcsawsDepartamento) departamentoDAO.save(departamento);
      if (comprobar.getIdDepartamento() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ELIMINAR DELETE DEPARTAMENTO
    else if (request.getTipo_query_generico() == 69) {

      UcsawsDepartamento departamento =
          departamentoDAO.obtenerDepartamentoById((Integer.parseInt(request.getQuery_generico())));

      try {
        departamentoDAO.delete(departamento);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // DISTRITOS BY ID EVENTO
    else if (request.getTipo_query_generico() == 70) {
      List<UcsawsDistrito> distrito = new ArrayList<UcsawsDistrito>();
      distrito =
          distritoDAO.obtenerDistritoByIdEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(distrito.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(distrito);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(distrito);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // DEPARTAMENTO BY ID
    else if (request.getTipo_query_generico() == 71) {
      UcsawsDepartamento departamento = new UcsawsDepartamento();
      departamento =
          departamentoDAO.obtenerDepartamentoById((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(departamento.getIdDepartamento() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(departamento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(departamento);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // guardar DISTRITO
    else if (request.getTipo_query_generico() == 72) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsDistrito distrito = mapper.readValue(jsonInString, UcsawsDistrito.class);

      // genero.setUsuarioIns("sistema");
      // tipoEvento.setFchIns(new Date());

      UcsawsDistrito comprobar = (UcsawsDistrito) distritoDAO.save(distrito);
      if (comprobar.getIdDistrito() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ELIMINAR DELETE DISTRITO
    else if (request.getTipo_query_generico() == 73) {

      UcsawsDistrito distrito =
          distritoDAO.obtenerDistritoById((Integer.parseInt(request.getQuery_generico())));

      try {
        distritoDAO.delete(distrito);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ZONA BY ID EVENTO
    else if (request.getTipo_query_generico() == 74) {
      List<UcsawsZona> zona = new ArrayList<UcsawsZona>();
      zona = zonaDAO.obtenerZonaByIdEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(zona.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(zona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(zona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // guardar ZONA
    else if (request.getTipo_query_generico() == 75) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsZona zona = mapper.readValue(jsonInString, UcsawsZona.class);

      // genero.setUsuarioIns("sistema");
      // tipoEvento.setFchIns(new Date());
      // departamento.setIdDepartamento(null);

      UcsawsZona comprobar = (UcsawsZona) zonaDAO.save(zona);
      if (comprobar.getIdZona() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ELIMINAR DELETE ZONA
    else if (request.getTipo_query_generico() == 76) {

      UcsawsZona zona = zonaDAO.obtenerZonaById((Integer.parseInt(request.getQuery_generico())));

      try {
        zonaDAO.delete(zona);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // DISTRITO BY ID
    else if (request.getTipo_query_generico() == 77) {
      UcsawsDistrito distrito = new UcsawsDistrito();
      distrito = distritoDAO.obtenerDistritoById((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(distrito.getIdDistrito() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(distrito);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(distrito);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // LOCAL BY ID
    else if (request.getTipo_query_generico() == 78) {
      UcsawsLocal local = new UcsawsLocal();
      local = localDAO.obtenerLocalById((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(local.getIdLocal() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(local);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(local);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // LOCAL BY ID EVENTO
    else if (request.getTipo_query_generico() == 79) {
      List<UcsawsLocal> local = new ArrayList<UcsawsLocal>();
      local = localDAO.obtenerLocalByIdEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(local.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(local);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(local);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // guardar LOCAL
    else if (request.getTipo_query_generico() == 80) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsLocal local = mapper.readValue(jsonInString, UcsawsLocal.class);

      // genero.setUsuarioIns("sistema");
      // tipoEvento.setFchIns(new Date());
      // departamento.setIdDepartamento(null);

      UcsawsLocal comprobar = (UcsawsLocal) localDAO.save(local);
      if (comprobar.getIdLocal() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ELIMINAR DELETE LOCAL
    else if (request.getTipo_query_generico() == 81) {

      UcsawsLocal local =
          localDAO.obtenerLocalById((Integer.parseInt(request.getQuery_generico())));

      try {
        localDAO.delete(local);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ZONA BY ID
    else if (request.getTipo_query_generico() == 82) {
      UcsawsZona zona = new UcsawsZona();
      zona = zonaDAO.obtenerZonaById((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(zona.getIdZona() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(zona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(zona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // DISTRITOS BY ID DEPARTAMENTO
    else if (request.getTipo_query_generico() == 83) {
      List<UcsawsDistrito> distrito = new ArrayList<UcsawsDistrito>();
      distrito =
          distritoDAO
              .obtenerDistritoByIdDepartamento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(distrito.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(distrito);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(distrito);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // ZONAs by id DISTRITO
    else if (request.getTipo_query_generico() == 84) {
      List<UcsawsZona> zona = new ArrayList<UcsawsZona>();
      zona = zonaDAO.obtenerZonaByIdDistrito((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(zona.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(zona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(zona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }


    // local by id ZONAs
    else if (request.getTipo_query_generico() == 85) {
      List<UcsawsLocal> local = new ArrayList<UcsawsLocal>();
      local = localDAO.obtenerLocalByIdZona(((Integer.parseInt(request.getQuery_generico()))));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(local.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(local);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(local);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }


    // LOCAL BY ID
    else if (request.getTipo_query_generico() == 86) {
      UcsawsLocal local = new UcsawsLocal();
      local = localDAO.obtenerLocalById((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(local.getIdLocal() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(local);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(local);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // MESA BY ID EVENTO
    else if (request.getTipo_query_generico() == 87) {
      List<UcsawsMesa> mesa = new ArrayList<UcsawsMesa>();
      mesa = mesaDAO.obtenerMesaByIdEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(mesa.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(mesa);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(mesa);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // guardar MESA
    else if (request.getTipo_query_generico() == 88) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsMesa mesa = mapper.readValue(jsonInString, UcsawsMesa.class);

      // genero.setUsuarioIns("sistema");
      // tipoEvento.setFchIns(new Date());
      // departamento.setIdDepartamento(null);

      UcsawsMesa comprobar = (UcsawsMesa) mesaDAO.save(mesa);
      if (comprobar.getIdMesa() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ELIMINAR DELETE MESA
    else if (request.getTipo_query_generico() == 89) {

      UcsawsMesa mesa = mesaDAO.obtenerMesaById((Integer.parseInt(request.getQuery_generico())));

      try {
        mesaDAO.delete(mesa);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // MESA by id LOCAL
    else if (request.getTipo_query_generico() == 90) {
      List<UcsawsMesa> mesa = new ArrayList<UcsawsMesa>();
      mesa = mesaDAO.obtenerMesaByIdLocal(((Integer.parseInt(request.getQuery_generico()))));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(mesa.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(mesa);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(mesa);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // NACIONALIDAD BY ID EVENTO
    else if (request.getTipo_query_generico() == 91) {
      List<UcsawsNacionalidad> nacionalidad = new ArrayList<UcsawsNacionalidad>();
      nacionalidad =
          nacionalidadDAO
              .obtenerNacionalidadByEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(nacionalidad.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(nacionalidad);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(nacionalidad);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // PAIS BY ID EVENTO
    else if (request.getTipo_query_generico() == 92) {
      List<UcsawsPais> pais = new ArrayList<UcsawsPais>();
      pais = paisDAO.obtenerPaisByEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(pais.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(pais);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(pais);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // ELIMINAR DELETE TIPO LISTA
    else if (request.getTipo_query_generico() == 93) {

      UcsawsTipoLista tipoLista =
          tipoListaDAO.obtenerTipoListaById((Integer.parseInt(request.getQuery_generico())));

      try {
        tipoListaDAO.delete(tipoLista);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // TIPO LISTA BY ID
    else if (request.getTipo_query_generico() == 94) {
      UcsawsTipoLista tipoLista = new UcsawsTipoLista();
      tipoLista =
          tipoListaDAO.obtenerTipoListaById((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(tipoLista.getIdTipoLista() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(tipoLista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(tipoLista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // TIPO LISTA BY ID EVENTO
    else if (request.getTipo_query_generico() == 95) {
      List<UcsawsTipoLista> tipoLista = new ArrayList<UcsawsTipoLista>();
      tipoLista =
          tipoListaDAO.obtenerTipoListaByIdEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(tipoLista.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(tipoLista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(tipoLista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }


    // guardar TIPO LISTA
    else if (request.getTipo_query_generico() == 96) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsTipoLista tipoLista = mapper.readValue(jsonInString, UcsawsTipoLista.class);

      // genero.setUsuarioIns("sistema");
      // tipoEvento.setFchIns(new Date());
      // departamento.setIdDepartamento(null);

      UcsawsTipoLista comprobar = (UcsawsTipoLista) tipoListaDAO.save(tipoLista);
      if (comprobar.getIdTipoLista() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // LISTA BY ID EVENTO
    else if (request.getTipo_query_generico() == 97) {
      List<UcsawsListas> lista = new ArrayList<UcsawsListas>();
      lista = listasDAO.obtenerListaByEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(lista.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(lista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(lista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }


    // actualizar LISTA modificar update
    else if (request.getTipo_query_generico() == 98) {
      // json string to java object;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();

      System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonInString));

      UcsawsListas lista = mapper.readValue(jsonInString, UcsawsListas.class);

      Object comprobar = listasDAO.update(lista);
      if (comprobar == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(lista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }
    }

    // guardar LISTA
    else if (request.getTipo_query_generico() == 99) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsListas listas = mapper.readValue(jsonInString, UcsawsListas.class);

      // genero.setUsuarioIns("sistema");
      // tipoEvento.setFchIns(new Date());
      // departamento.setIdDepartamento(null);

      UcsawsListas comprobar = (UcsawsListas) listasDAO.save(listas);
      if (comprobar.getIdLista() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // ELIMINAR DELETE LISTA
    else if (request.getTipo_query_generico() == 100) {

      UcsawsListas lista =
          listasDAO.obtenerListaByID((Integer.parseInt(request.getQuery_generico())));

      try {
        listasDAO.delete(lista);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }

    // CANDIDATOS BY ID EVENTO
    else if (request.getTipo_query_generico() == 101) {
      List<UcsawsCandidatos> lista = new ArrayList<UcsawsCandidatos>();
      lista =
          candidatosDAO.obtenerCandidatosByEvento((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(lista.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(lista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(lista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // LISTA BY ID
    else if (request.getTipo_query_generico() == 102) {
      UcsawsListas lista = new UcsawsListas();
      lista = listasDAO.obtenerListaByID((Integer.parseInt(request.getQuery_generico())));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(lista.getIdLista() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(lista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(lista);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    // actualizar CANDIDATO modificar update
    else if (request.getTipo_query_generico() == 103) {
      // json string to java object;

      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();

      System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonInString));

      UcsawsCandidatos candidato = mapper.readValue(jsonInString, UcsawsCandidatos.class);

      Object comprobar = candidatosDAO.update(candidato);
      if (comprobar == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(candidato);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }
    }

    // guardar CANDIDATO
    else if (request.getTipo_query_generico() == 104) {

      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsCandidatos candidato = mapper.readValue(jsonInString, UcsawsCandidatos.class);

      // genero.setUsuarioIns("sistema");
      // tipoEvento.setFchIns(new Date());
      // departamento.setIdDepartamento(null);

      UcsawsCandidatos comprobar = (UcsawsCandidatos) candidatosDAO.save(candidato);
      if (comprobar.getIdCandidatos() == null) {
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } else {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }
    
    // ELIMINAR DELETE CANDIDATO
    else if (request.getTipo_query_generico() == 105) {
      
      // json string to java object;
      ObjectMapper mapper = new ObjectMapper();
      String jsonInString = request.getQuery_generico();
      UcsawsCandidatos candidato = mapper.readValue(jsonInString, UcsawsCandidatos.class);

      try {
        candidatosDAO.delete(candidato);
      } catch (Exception e) {
        System.out.println(e);
        response.setCodigo(2244);
        response.setQuery_generico_response("NO");
      } finally {
        response.setCodigo(2244);
        response.setQuery_generico_response("SI");
      }

    }
    
    // CANDIDATO BY ID
    else if (request.getTipo_query_generico() == 106) {
      UcsawsCandidatos candidato = new UcsawsCandidatos();
      candidato = candidatosDAO.obtenerCandidatosByID(Integer.parseInt(request.getQuery_generico()));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(candidato.getIdCandidatos() == null)) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(candidato);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(candidato);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }
    
    // consultar PERSONAS no candidatas by evento
    else if (request.getTipo_query_generico() ==  107) {

      // json string to List<String>;
      /*
       * ObjectMapper mapper = new ObjectMapper(); String jsonInString =
       * request.getQuery_generico(); List<String> lista = mapper.readValue(jsonInString,
       * List.class);
       */

      List<UcsawsPersona> persona = new ArrayList<UcsawsPersona>();
      persona = personaDAO.obtenerPersonaByEventoNoCandidatas(Integer.parseInt(request.getQuery_generico()));

      // users = usersDAO.consultarUsuario(lista.get(0), lista.get(1));

      if (!(persona.isEmpty())) {

        // parseo json
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(persona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      } else {
        ObjectMapper mapperObj = new ObjectMapper();
        String jsonStr = "";
        try {
          // get Employee object as a json string
          jsonStr = mapperObj.writeValueAsString(persona);
          System.out.println(jsonStr);
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

        response.setCodigo(2244);
        response.setQuery_generico_response(jsonStr);
      }

    }

    return response;

  }

  public static JSONObject objectToJSONObject(Object object) {
    Object json = null;
    JSONObject jsonObject = null;
    try {
      json = new JSONTokener(object.toString()).nextValue();
    } catch (JSONException e) {
      e.printStackTrace();
    }
    if (json instanceof JSONObject) {
      jsonObject = (JSONObject) json;
    }
    return jsonObject;
  }

}
