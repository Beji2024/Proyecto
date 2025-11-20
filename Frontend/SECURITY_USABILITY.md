Recomendaciones de Seguridad y Usabilidad - Login

- No mostrar la contraseña por defecto: el campo de contraseña debe estar enmascarado por defecto y ofrecer un control "mostrar/ocultar" bajo demanda. Esto evita exposiciones accidentales en pantallas compartidas.

- Política de contraseñas: aplicar y documentar una política mínima (por ejemplo: mínimo 8 caracteres, incluir mayúsculas, minúsculas, números y/o caracteres especiales según riesgo). Mostrar esta política en el formulario de ingreso o en la pantalla de cambio/restablecimiento de contraseña.

- Tooltips y ayudas breves: incluir textos breves y claros en los campos críticos. Ejemplos usados en la interfaz:
  - Campo Email: "Ingrese el correo electrónico registrado en Sport10."
  - Campo Contraseña: "La contraseña distingue mayúsculas y minúsculas. Mínimo 8 caracteres."

- Mensajes de carga: mostrar un indicador visual (spinner) y texto mientras se valida la sesión, p.ej. "Validando credenciales...". Deshabilitar el botón de envío mientras se procesa la solicitud para evitar envíos duplicados.

- Manejo de errores de servidor: diferenciar errores de credenciales (usuario/contraseña) de errores de servidor (respuesta inválida, token ausente). Mostrar mensajes amigables sin filtrar detalles técnicos.

- Recuperación y soporte: ofrecer un enlace o contacto directo para restablecimiento de contraseña (por ejemplo, correo del administrador o ticket). Evitar exponer direcciones o datos sensibles públicamente.

- Accesibilidad: asegurar que los controles tengan atributos `aria-*` adecuados y que los iconos tengan textos alternativos o `title` para usuarios de lectores de pantalla.

- Registro y auditoría: registrar intentos de inicio de sesión fallidos y bloquear/alertar tras múltiples intentos fallidos (política configurable).

- Revisión periódica: revisar la implementación y la UX para detectar fricciones o puntos de riesgo y ajustarlos según el feedback de usuarios y los hallazgos de seguridad.
