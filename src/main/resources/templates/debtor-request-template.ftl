<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://ws.iifcore.fiergs.org.br/">
   <soapenv:Header/>
   <soapenv:Body>
      <ws:consultarInadimplencia>
         <cpfCnpj>${taxpayerId}</cpfCnpj>
      </ws:consultarInadimplencia>
   </soapenv:Body>
</soapenv:Envelope>