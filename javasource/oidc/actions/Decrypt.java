// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package oidc.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.crypto.RSADecrypter;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.RSAKey;

public class Decrypt extends CustomJavaAction<java.lang.String>
{
	private java.lang.String jwk;
	private java.lang.String data;

	public Decrypt(IContext context, java.lang.String jwk, java.lang.String data)
	{
		super(context);
		this.jwk = jwk;
		this.data = data;
	}

	@java.lang.Override
	public java.lang.String executeAction() throws Exception
	{
		// BEGIN USER CODE
		JWK jwkObj = JWK.parse(jwk);
		JWEObject jwe = JWEObject.parse(data);
		
		if (jwkObj instanceof RSAKey) {
			RSAKey rsaKey = (RSAKey) jwkObj;
			RSADecrypter decrypter = new RSADecrypter(rsaKey.toRSAPrivateKey());
			jwe.decrypt(decrypter);
		}
		
		return jwe.getPayload().toString();		
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "Decrypt";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}